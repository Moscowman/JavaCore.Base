package lesson7;

public class Box {
    private String color;
    private int size;

    public Box(String color, int size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if(!obj.getClass().equals(Box.class)){
            return false;
        }

        Box another = (Box)obj;

        if(!color.equals(another.color)){
            return false;
        }

        return size == another.size;
    }

    @Override
    public int hashCode() {
        return 31 * color.hashCode() + size;
    }

    @Override
    public String toString() {
        return "Box{" +
                "color='" + color + '\'' +
                ", size=" + size +
                '}';
    }
}
