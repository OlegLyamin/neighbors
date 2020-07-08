import java.util.Objects;

public class Element {
    private int x;
    private int y;

    @Override
    public String toString() {
        return "Element{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Element(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
