package JavaCore.Base.Lesson6;

import JavaCore.Base.Lesson6.Animals.*;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Шарик");
        Dog dog2 = new Dog("Верный");
        Dog dog3 = new Dog();

        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat();

        dog1.run(100);
        dog2.run(500);
        dog3.run(1000);
        cat1.run(400);
        cat2.run(50);

        dog1.swim(10);
        dog2.swim(50);
        dog3.swim(100);
        cat1.swim(40);
        cat2.swim(5);


        System.out.println("Всего животных создано: " + Animal.getCount());
        System.out.println("Собак создано: " + Dog.getCount());
        System.out.println("Котов создано: " + Cat.getCount());
    }
}
