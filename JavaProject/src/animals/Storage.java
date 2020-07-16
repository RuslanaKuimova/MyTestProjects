package animals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Storage {
    public Cat[] cats;
    public List<Cat> cats2 = new ArrayList<Cat>();

    public Storage() {
        this.cats = new Cat[0];

    }

    //arrayList____________________________________________________
    public void add2(Cat cat) {
        cats2.add(cat);

    }

    public void remove2(Cat cat) {
        cats2.remove(cat);
    }

    public void edit2(Cat cat, Cat cat2) {
        for (int i = 0; i < this.cats2.size(); i++) {
            if (this.cats2.get(i).equals(cat)) {

                int j = this.cats2.indexOf(cat);
                this.cats2.set(j, cat2);
            }
        }

    }

    public List<Cat> getAll2() {
        return cats2;
    }

    public void getName2() {
        for (int i = 0; i < this.cats2.size(); i++) {
            String getName = this.cats2.get(i).name;
            System.out.println(getName);
        }
    }


    //array__________________________________________________
    public void add(Cat cat) {
        Cat[] newCats = new Cat[this.cats.length + 1]; //создаем новый массив
        for (int i = 0; i < this.cats.length; i++) { //переносим данные из старого массива
            newCats[i] = this.cats[i];
        }
        newCats[newCats.length - 1] = cat;//добавляем новый объект в конец массива
        cats = newCats;//
    }

    public void remove(Cat cat) {
        int counter = 0;
        for (int i = 0; i < this.cats.length; i++) {
            // Cat[] newCats;

            if (this.cats[i].equals(cat)) {
                //    newCats = new Cat[this.cats.length-1];
                this.cats[i] = null;
                counter++;

            }
        }
        if (counter != 0) {
            Cat[] newCats = new Cat[this.cats.length - counter];
            int j = 0;
            for (int i = 0; i < this.cats.length; i++) {
                if (this.cats[i] != null) {
                    newCats[j] = this.cats[i];
                    j++;

                }
            }
            this.cats = newCats;
            // System.out.println(this.cats);
        }

    }

    public void edit(Cat cat, Cat cat2) {
        for (int i = 0; i < this.cats.length; i++) {

            if (this.cats[i].equals(cat)) {
                this.cats[i] = cat2;
            }
        }


    }

    public Cat[] getAll() {
        return cats;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "cats=" + Arrays.toString(cats) +
                '}';
    }

    public void getName() {
        String[] getName = new String[this.cats.length];
        for (int i = 0; i < this.cats.length; i++) {
            getName[i] = this.cats[i].name;
            System.out.println(getName[i]);
        }

    }


}
