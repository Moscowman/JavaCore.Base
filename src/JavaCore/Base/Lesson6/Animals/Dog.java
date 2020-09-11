package JavaCore.Base.Lesson6.Animals;

public class Dog extends Animal {

    static private int count;

    public Dog() {
        count++;
        maxDistance[MOVE_TYPE_RUN] = 500;
        maxDistance[MOVE_TYPE_SWIM] = 10;
        noNameMoveMessage[MOVE_TYPE_RUN] = "Собака пробежала";
        noNameCouldNotMoveMessage[MOVE_TYPE_RUN] = "Собака не способна пробежать";
        noNameMoveMessage[MOVE_TYPE_RUN] = "Собака пробежала";
        noNameCouldNotMoveMessage[MOVE_TYPE_RUN] = "Собака не способна пробежать";
        noNameMoveMessage[MOVE_TYPE_SWIM] = "Собака проплыла";
        noNameCouldNotMoveMessage[MOVE_TYPE_SWIM] = "Собака не способна проплыть";
        noNameMoveMessage[MOVE_TYPE_SWIM] = "Собака проплыла";
        noNameCouldNotMoveMessage[MOVE_TYPE_SWIM] = "Собака не способна проплыть";
    }

    public Dog(String name) {
        this();
        this.name = name;
    }


    public static int getCount() {
        return count;
    }
}
