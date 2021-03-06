package JavaCore.Base.Lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public boolean decreaseFood(int amount) {
        if (amount > this.food) {
            return false;
        }
        this.food -= amount;
        return true;
    }

    public int addFood(int amount) {
        this.food += amount;
        return this.food;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }
}
