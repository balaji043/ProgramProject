package common.noOfRectangles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pair {
    int i;
    int j;

    @Override
    public boolean equals(Object obj) {
        Pair pair = (Pair) obj;
        return pair != null && this.i == pair.i && this.j == pair.j;
    }

}
