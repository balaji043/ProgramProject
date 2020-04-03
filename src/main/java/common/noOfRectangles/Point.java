package common.noOfRectangles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
public class Point {
    int x;
    int y;

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
