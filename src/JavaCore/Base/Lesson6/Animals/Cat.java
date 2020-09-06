package JavaCore.Base.Lesson6.Animals;

public class Cat extends Animal {

    static private int count;
    public Cat() {
        count++;
        maxDistance[MOVE_TYPE_RUN] = 200;
        maxDistance[MOVE_TYPE_SWIM] = 0;
        noNameMoveMessage[MOVE_TYPE_RUN] = "Кот пробежал";
        noNameCouldNotMoveMessage[MOVE_TYPE_RUN] = "Кот не способен пробежать";
        noNameMoveMessage[MOVE_TYPE_SWIM] = "Кот проплыл";
        noNameCouldNotMoveMessage[MOVE_TYPE_SWIM] = "Кот не способен проплыть";
        namedMoveMessage[MOVE_TYPE_RUN] = "пробежал";
        namedCouldNotMoveMessage[MOVE_TYPE_RUN] = "не способeн пробежать";
        namedMoveMessage[MOVE_TYPE_SWIM] = "проплыл";
        namedCouldNotMoveMessage[MOVE_TYPE_SWIM] = "не способен проплыть";
    }

    public Cat(String name) {
        this();
        this.name = name;
    }

    public static int getCount() {
        return count;
    }
}
