package restassured;

import entities.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasKey;

public class CreateUserTest {
    @Before
    public void beforeMethod() {
        RestAssured.baseURI = "http://151.80.70.42";
        //RestAssured.basePath="/api/users";
        RestAssured.port = 3000;

    }

    @Test
    public void createStudents() {
        String name = "Student_1234";
        String newName = "New_student_1234";
        String phone = "4455788";
        String newPhone = "777777777";
        String role = "Student";
        int id;
        int id1;

        String userGetName;


        Response createStudent = given()
                .basePath("/api/users")
                .body("{\"name\":\"" + name + "\",\"phone\":\"" + phone + "\",\"role\":\"" + role + "\"}")
                .contentType(ContentType.JSON)
                .when()
                .post();
        createStudent.then()
                .body("$", hasKey("id"))
                .body("$", hasKey("role"))
                .body("$", hasKey("name"))
                .body("$", hasKey("phone"))
                .statusCode(200);

        id = new JsonPath(createStudent.getBody().asString()).getInt("id");


        User[] users = given()
                .basePath("/api/users")
                .when()
                .get()
                .then()
                .extract()
                .body()
                .as(User[].class);


        System.out.println(id);

        List<User> userList = Arrays.asList(users);
        boolean userExists = false;
        for (User user : userList) {
            //  System.out.println(user);

            if (user.getId() == id) {
                System.out.println(user.getName());
                System.out.println(user.getPhone());
                userExists = true;
            }
        }
        Assert.assertTrue(userExists);

        Response editStudent = given()
                .basePath("/api/users/" + id + "")
                .body("{\"id\":" + id + ",\"name\":\"" + newName + "\",\"phone\":\"" + newPhone + "\",\"role\":\"" + role + "\",\"strikes\":\"1\",\"location\":\"\"}")
                .contentType(ContentType.JSON)
                .when()
                .put();
        editStudent.then()
                .statusCode(204);

        users = given()
                .basePath("/api/users")
                .when()
                .get()
                .then()
                .extract()
                .body()
                .as(User[].class);


        userList = Arrays.asList(users);

        for (User user : userList) {
            //  System.out.println(user);

            if (user.getId() == id) {
                System.out.println(user.getName());
                System.out.println(user.getPhone());
                Assert.assertTrue(user.getName().equals(newName));
                Assert.assertTrue(user.getPhone().equals(newPhone));

            }
        }


//удаляем юзера
        Response deleteStudent = given()
                .basePath("/api/users/" + id + "")
                .contentType(ContentType.JSON)
                .when()
                .delete();
        deleteStudent.then()
                .statusCode(204);


        //проверяем что юзер удалился
        users = given()
                .basePath("/api/users")
                .when()
                .get()
                .then()
                .extract()
                .body()
                .as(User[].class);


        userList = Arrays.asList(users);

        for (User user : userList) {
            //  System.out.println(user);

            if (user.getId() == id) {
                userExists = false;
            }
        }
        Assert.assertTrue(userExists);


    }

}
