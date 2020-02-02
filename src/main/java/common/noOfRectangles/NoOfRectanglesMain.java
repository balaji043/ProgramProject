package common.noOfRectangles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoOfRectanglesMain {
    public static void main(String[] args) {
        int m = 4, n = 2;
        List<Point> points = new ArrayList<>();
        int k = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Point p = new Point(i, j);
                points.add(p);
                System.out.print(k++ + "." + p.toString() + "\t");
            }
            System.out.println();
        }
        int noOfRRectangles = getNoOfRectangles(points);
        System.out.println(noOfRRectangles);
    }
    //0,0 0,1 0,2
    //1,0 1,1 ,1,2

    private static int getNoOfRectangles(List<Point> points) {
        int answer = 0;
        Map<String, Integer> pairCountsAbove = new HashMap<>();
        for (Point point : points) {
            for (Point pointAbove : points) {
                if (point.x == pointAbove.x && point.y < pointAbove.y) {
                    String pair = "" + point.y + " " + pointAbove.y;
                    if (!pairCountsAbove.containsKey(pair)) {
                        pairCountsAbove.put(pair, 1);
                    } else {
                        pairCountsAbove.put(pair, pairCountsAbove.get(pair) + 1);
                    }
                    answer += pairCountsAbove.get(pair) - 1;
                    System.out.println(point.toString() + " " + pointAbove.toString() + " " + pair + " " + pairCountsAbove.get(pair) + " " + answer);
                }
            }
        }

//        for (Map.Entry<String, Integer> pair : pairCountsAbove.entrySet()) {
//            System.out.println(pair);
//            System.out.println(pairCountsAbove.get(pair.getKey()));
//        }
        return answer;
    }
}
