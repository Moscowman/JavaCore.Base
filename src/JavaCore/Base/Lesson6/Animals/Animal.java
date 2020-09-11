package JavaCore.Base.Lesson6.Animals;

public class Animal {
    final int MOVE_TYPE_RUN = 0;
    final int MOVE_TYPE_SWIM = 1;
    static private int count;
    protected String name;
    protected int[] maxDistance = new int[2];
    protected String[] noNameMoveMessage = new String[2];
    protected String[] noNameCouldNotMoveMessage = new String[2];
    protected String[] namedMoveMessage = new String[2];
    protected String[] namedCouldNotMoveMessage = new String[2];
    public static void setCount(int count) {
        Animal.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal() {
        count++;
        maxDistance[MOVE_TYPE_RUN] = 0;
        maxDistance[MOVE_TYPE_SWIM] = 0;
        noNameMoveMessage[MOVE_TYPE_RUN] = "Животное пробежало";
        noNameCouldNotMoveMessage[MOVE_TYPE_RUN] = "Животное не способно пробежать";
        noNameMoveMessage[MOVE_TYPE_SWIM] = "Животное проплыло";
        noNameCouldNotMoveMessage[MOVE_TYPE_SWIM] = "Животное не способно проплыть";
        namedMoveMessage[MOVE_TYPE_RUN] = "пробежал";
        namedCouldNotMoveMessage[MOVE_TYPE_RUN] = "не способeн пробежать";
        namedMoveMessage[MOVE_TYPE_SWIM] = "проплыл";
        namedCouldNotMoveMessage[MOVE_TYPE_SWIM] = "не способен проплыть";
    }

    public Animal(String name) {
        this();
        this.name = name;
    }

    public void run(int distance) {
        move(0, distance);
    }

    public void swim(int distance) {
        move(1, distance);
    }

    private void move(int type, int distance) {
        if (distance <= maxDistance[type]) {
            if (name != null) {
                System.out.print(name + " " + namedMoveMessage[type] + " ");
            } else {
                System.out.print(noNameMoveMessage[type] + " ");
            }
        } else {
            if (name != null) {
                System.out.print(name + " " + namedCouldNotMoveMessage[type] + " ");
            } else {
                System.out.print(noNameCouldNotMoveMessage[type] + " ");
            }
        }
        System.out.println(distance + " метров");
    }

    public static int getCount() {
        return count;
    }
}
