import animals.Animal;
import animals.Cat;
import animals.Dog;
import animals.Storage;

public class JavaOOPExamples {
    public static void main(String[] args) {
        Storage store = new Storage();
//ArrayList___________________________________________________________________________
        store.add2(new Cat("vasya", 5, "brown"));
        store.add2(new Cat("petya", 1, "white"));
        store.add2(new Cat("kuzya", 3, "grey"));
        //store.cats2.size();
        System.out.println(store.getAll2().size());
        store.getName2();
        store.edit2(new Cat("petya", 1, "white"), new Cat("julick", 1, "white"));
        System.out.println(store.getAll2().size());
        store.getName2();

        store.remove2(new Cat("vasya", 5, "brown"));
        System.out.println(store.getAll2().size());
        store.getName2();

        store.remove2(new Cat("petya", 1, "white"));
        System.out.println(store.getAll2().size());
        store.getName2();

//Array_____________________________________________________________________________
        store.add(new Cat("vasya", 5, "brown"));
        store.add(new Cat("petya", 1, "white"));
        store.add(new Cat("kuzya", 3, "grey"));
        store.getName();
        store.edit(new Cat("vasya", 5,"brown"), new Cat ("pushok", 5,"brown"));
        System.out.println(store.getAll().length);
        store.getName();

        store.remove(new Cat("vasya", 5,"brown"));
        System.out.println(store.getAll().length);
        store.getName();
        store.remove(new Cat("kuzya", 3,"grey"));
        System.out.println(store.getAll().length);
        store.getName();

//        Cat cat = new Cat();
//        Dog dog = new Dog();
//        cat.sound();
//        dog.sound();
//        Animal[] aaa = {new Cat(), new Cat(), new Dog(), new Cat(), new Dog()};
//        for (int i = 0; i < aaa.length; i++) {
//            aaa[i].sound();
//        }
//        animals.Cat myCat = new animals.Cat();
//        myCat.age = 3;
//        myCat.name = "Vaska";
//        myCat.color = "red";
//        Cat myCat2 = new Cat("Murzik", 5, "grey");
//        Cat myCat3 = new Cat(myCat2);
//
//        System.out.println(myCat2);
//        System.out.println(myCat3);
//        System.out.println(myCat2.equals(myCat3));
//        myCat.go();

//        System.out.print("Vaska says: " + "\n");
//        System.out.println("Vaska says: ");
//        myCat.sound();
//        myCat.eat("kolbasa", "fish");
//        myCat2.eat("korm");
//        System.out.println(myCat.sound());


//        int[] arrayOfNumbers = {1, 56, 34, 234, 3456, 67, 5678543, 234, 1124};
//        int[] arrayOfNumbers2 = new int[10];
//
//        for (int i = 0; i < 9; i = i + 1) {
//            if (arrayOfNumbers[i] == 234) {
//                System.out.println("Found");
//                continue;
//            }
//            System.out.println(i);
//        }
//        System.out.println(arrayOfNumbers[6]);
//        int a = 56;
//        long b = 456345634;
//        byte c = 54;
//        short d = 345;
//
//        float e = 4.34f;
//        double f = 435234.456;
//
//        char g = 'w';
//
//        boolean h = true;
//
//        String name = "Petya";
//        a = 0;
//        if (a < 0) {
//            System.out.println("Sub-Zero");
//        } else if (a == 0) {
//            System.out.println("Zero");
//        } else {
//            System.out.println("Above-Zero");
//        }
//
//        System.out.println("Hello, " + name + "!");
    }
}
