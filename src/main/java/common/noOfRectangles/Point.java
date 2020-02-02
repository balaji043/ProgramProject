package common.noOfRectangles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Point {
    int x;
    int y;

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
