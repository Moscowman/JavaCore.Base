package JavaCore.Base.Lesson7;

public class Main {
    public static void main(String[] args) {

        Cat[] cats = {
                new Cat("Barsik", 10),
                new Cat("Murzik", 20),
                new Cat("Kisik", 5),
                new Cat("Apoll      on", 40),
                new Cat("Z16-D4", 50)
        };
        Plate plate = new Plate(100);

        for (Cat cat: cats) {
            cat.eat(plate);
        }

        for (Cat cat: cats) {
            if (cat.isWellFed()) {
                System.out.println("Cat " + cat.getName() + " is well-fed");
            } else {
                System.out.println("Cat " + cat.getName() + " is hungry");
            }
        }

        System.out.println("Добавили еды. Теперь в тарелке " + plate.addFood(33) + " единиц еды");

        //Dog dog = new Dog("Tuzik");
        //dog.scare(cat);


    }

}
