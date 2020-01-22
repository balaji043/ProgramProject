package java;

import java.util.Scanner;

public class Robot45 {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int x = S.nextInt();
        int y = S.nextInt();
        String s1 = S.next();
        S.nextLine();
        String s2 = S.nextLine();
        System.out.println(moveRobot(x, y, s1, s2));
    }

    private static String moveRobot(int input1, int input2, String input3, String input4) {
        String[] pts = input3.split("-");
        String[] st = input4.split(" ");
        int curX = Integer.parseInt(pts[0]);
        int curY = Integer.parseInt(pts[1]);
        String d = pts[2];
        int v = 0;
        label:
        for (String s : st) {
            if (!s.equals("M")) {
                switch (d) {
                    case "N":
                        if (s.equals("R"))
                            d = "NE";
                        else if (s.equals("L"))
                            d = "NW";
                        break;
                    case "E":
                        if (s.equals("R"))
                            d = "SE";
                        else if (s.equals("L"))
                            d = "NE";
                        break;
                    case "W":
                        if (s.equals("R"))
                            d = "NW";
                        else if (s.equals("L"))
                            d = "SW";
                        break;
                    case "S":
                        if (s.equals("R"))
                            d = "SW";
                        else if (s.equals("L"))
                            d = "SE";
                        break;
                    case "NE":
                        if (s.equals("R"))
                            d = "E";
                        else if (s.equals("L"))
                            d = "N";
                        break;
                    case "NW":
                        if (s.equals("R"))
                            d = "N";
                        else if (s.equals("L"))
                            d = "W";
                        break;
                    case "SE":
                        if (s.equals("R"))
                            d = "S";
                        else if (s.equals("L"))
                            d = "E";
                        break;
                    case "SW":
                        if (s.equals("R"))
                            d = "W";
                        else if (s.equals("L"))
                            d = "S";
                        break;
                }

            } else {
                switch (d) {
                    case "N":
                        if (curY != input2) {
                            curY += 1;
                        } else {
                            v = 1;
                            break label;
                        }
                        break;
                    case "E":
                        if (curX != input1) {
                            curX += 1;
                        } else {
                            v = 1;
                            break label;
                        }
                        break;
                    case "W":
                        if (curX != 0) {
                            curX -= 1;
                        } else {
                            v = 1;
                            break label;
                        }
                        break;
                    case "S":
                        if (curY != 0) {
                            curY -= 1;
                        } else {
                            v = 1;
                            break label;
                        }
                        break;
                    case "NE":
                        if (curX != input1 && curY != input2) {
                            curX += 1;
                            curY += 1;
                        } else {
                            v = 1;
                            break label;
                        }
                        break;
                    case "NW":
                        if (curX != 0 && curY != input2) {
                            curX -= 1;
                            curY += 1;
                        } else {
                            v = 1;
                            break label;
                        }
                        break;
                    case "SE":
                        if (curX != input1 && curY != 0) {
                            curX += 1;
                            curY -= 1;
                        } else {
                            v = 1;
                            break label;
                        }
                        break;
                    case "SW":
                        if (curX != 0 && curY != 0) {
                            curX -= 1;
                            curY -= 1;
                        } else {
                            v = 1;
                            break label;
                        }
                        break;
                }
            }
        }
        if (v == 0)
            return "" + curX + "-" + curY + "-" + d;
        else
            return "" + curX + "-" + curY + "-" + d + "-" + "ER";
    }
}
