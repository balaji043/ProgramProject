package common.noOfRectangles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoOfRectanglesMain {
    public static void main(String[] args) {
        int m = 3, n = 3;
        List<Point> point1 = new ArrayList<>();
        List<Point> points2 = new ArrayList<>();

        int k = 1;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                Point p = new Point(i, j);
//                point1.add(p);
//                System.out.print(p.toString() + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println();

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                Point p = new Point(j, i);
                points2.add(p);
                System.out.print(p.toString() + "\t");
            }
            System.out.println();
        }
        System.out.println();

//        int noOfRectangles = getNoOfRectangles(point1);
//        System.out.println(noOfRectangles);
        System.out.println();

        int noOfDiagonalRectangles = getNoOfDiagonalRectangles(points2);

        System.out.println(noOfDiagonalRectangles);

    }

    private static int getNoOfDiagonalRectangles(List<Point> points) {
        int answer = 0;
        Map<String, Integer> pairCountsAbove = new HashMap<>();
        Map<String, List<Pair>> pairList = new HashMap<>();
        for (Point point : points) {
            for (Point pointAbove : points) {
                if (!point.equals(pointAbove) && point.x != pointAbove.x && point.y != pointAbove.y) {
                    String pair = "" + (pointAbove.x - point.x) + " " + (pointAbove.y - point.y);
                    Pair currentPair = new Pair(point, pointAbove);
                    List<Pair> pairs = null;
                    if (pairList.containsKey(pair)) {
                        pairs = pairList.get(pair);
                    } else {
                        pairs = new ArrayList<>();
                    }
                    pairs.add(currentPair);
                    pairList.put(pair, pairs);
                    if (!pairCountsAbove.containsKey(pair)) {
                        pairCountsAbove.put(pair, 1);
                    } else {
                        pairCountsAbove.put(pair, pairCountsAbove.get(pair) + 1);
                    }
                    if (pairs.size() > 1) {
                        Point c = currentPair.b;
                        Point d = currentPair.a;

                        for (Pair eachPair : pairs) {
                            Point a = eachPair.a;
                            Point b = eachPair.b;
                            String ad = "" + (a.x - d.x) + " " + (a.y - d.y);
                            String bc = "" + (b.x - c.x) + " " + (b.y - c.y);
                            if(ad.equalsIgnoreCase(bc)){
                                answer++;
                            }
                        }
                        // answer += pairCountsAbove.get(pair) - 1;
                    }
                    //System.out.println(point.toString() + " " + pointAbove.toString() + " " + pair + " " + pairCountsAbove.get(pair) + " " + answer);
                }
            }
        }
        return answer;
    }

    //1,0 1,1 ,1,2
    //0,0 0,1 0,2


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
                    // System.out.println(point.toString() + " " + pointAbove.toString() + " " + pair + " " + pairCountsAbove.get(pair) + " " + answer);
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
