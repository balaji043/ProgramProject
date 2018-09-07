import java.util.Scanner;

class Wipro_Robot {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] line1 = scanner.nextLine().split(" ");
        String[] line2 = scanner.nextLine().split("-");
        String[] line3 = scanner.nextLine().split(" ");

        int r = Integer.parseInt(line1[0]);
        int c = Integer.parseInt(line1[1]);

        System.out.println(moveRobot(r, c, line2, line3));
    }

    private static String moveRobot(int rows, int columns, String[] input3, String[] input4) {
        int x = Integer.parseInt(input3[0]), y = Integer.parseInt(input3[1]), a, b;
        String facing = "" + input3[2], f = facing;
        System.out.println("x = " + x + ",y = " + y);
        for (String op : input4) {
            a = x;
            b = y;
            if (isTurn(op)) {
                f = facing;
                facing = getFacing(op, facing);
                System.out.println(op + " Turn \n" + f + " -> " + facing);
            } else {
                System.out.println("Move");
                switch (facing) {
                    case "N": {
                        y++;
                        break;
                    }
                    case "S": {
                        y--;
                        break;
                    }
                    case "E": {
                        x++;
                        break;
                    }
                    case "W": {
                        x--;
                        break;
                    }
                }
                System.out.println("x = " + x + ",y = " + y);
                if (!isValid(x, y, rows, columns)) return "" + a + "-" + b + "-" + f + "-" + "ER";
            }
        }
        return "" + x + "-" + y + "-" + facing;
    }

    private static boolean isValid(int x, int y, int r, int c) {
        boolean ans = false;
        if (x >= 0 && y >= 0 && x <= r && y <= c)
            ans = true;
        return ans;
    }

    private static boolean isTurn(String op) {
        return op.equals("R") || op.equals("L");
    }

    private static String getFacing(String op, String facing) {
        switch (facing) {
            case "N": {
                if (op.equals("R"))
                    facing = "E";
                else
                    facing = "W";
                break;
            }
            case "E": {
                if (op.equals("R"))
                    facing = "S";
                else
                    facing = "N";
                break;
            }
            case "W": {
                if (op.equals("R"))
                    facing = "N";
                else
                    facing = "S";
                break;
            }
            case "S": {
                if (op.equals("R"))
                    facing = "W";
                else
                    facing = "E";
                break;
            }
        }
        return facing;
    }
}

/*

3 3
2-2-E
R M L M L M

3 4 
2-2-E
R M L M L M R M

*/
