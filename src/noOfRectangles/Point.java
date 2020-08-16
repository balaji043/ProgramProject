package noOfRectangles;



import java.util.Objects;


public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ')';
    }

    @Override
    public boolean equals(Object obj) {
        Point point = (Point) obj;
        return point != null && this.x == point.x && this.y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
