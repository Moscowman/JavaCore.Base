package JavaCore.Base.Lesson7;

public class Cat {
    private String name;
    private boolean satiety;
    private int voracity;

    public Cat(String name, int voracity) {
        this.name = name;
        this.satiety = false;
        this.voracity = voracity;
    }

    public void eat(Plate plate) {
        satiety = plate.decreaseFood(voracity);
        if (satiety) {
            System.out.println("Cat " + name + " has eaten " + voracity + " items of food");
        } else {
            System.out.println("Cat " + name + " hasn't eaten any food");
        }
    }

    public boolean isWellFed() {
        return satiety;
    }


    public String getName() {
        return name;
    }

    public void fear(Dog dog){
        System.out.println("Cat "+ name+" fear dog "+ dog.getName());
    }
}
