import java.util.Scanner;

class Wipro_Robot {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] line1 = scanner.nextLine().split(" ");
        String line2 = scanner.nextLine();
        String line3 = scanner.nextLine();

        int r = Integer.parseInt(line1[0]);
        int c = Integer.parseInt(line1[1]);

        System.out.println(Robot_90_45_Movement.moveRobot(r, c, line2, line3));
    }
}

class Robot_90_45_Movement {
    static String moveRobot(int r, int c, String input3, String input4) {
        int a, b, u;
        String[] position = input3.split("-");
        int x = Integer.parseInt(position[0]);
        int y = Integer.parseInt(position[1]);
        String facing = position[2], f;
        String[] moves = " ".split(input4);
        for (String move : moves) {
            a = x;
            b = y;
            f = facing;
            if (isTurn(move)) {
                facing = getFacing(move, facing);
            } else {
                if (move.equals("M"))
                    u = 2;
                else
                    u = 1;
                switch (facing) {
                    case "N": {
                        y += u;
                        break;
                    }
                    case "NE": {
                        y += u;
                        x += u;
                        break;
                    }
                    case "E": {
                        x += u;
                        break;
                    }
                    case "SE": {
                        y -= u;
                        x += u;
                        break;
                    }
                    case "S": {
                        y -= u;
                        break;
                    }
                    case "SW": {
                        y -= u;
                        x -= u;
                        break;
                    }
                    case "W": {
                        x -= u;
                        break;
                    }
                    case "NW": {
                        y += u;
                        x -= u;
                        break;
                    }
                }
                if (!isValid(x, y, r, c)) {
                    return "" + a + "-" + b + "-" + f + "-ER";
                }
            }
        }
        return "" + x + "-" + y + "-" + facing;
    }

    private static boolean isTurn(String op) {
        return op.equals("R") || op.equals("L") || op.equals("l") || op.equals("r");
    }

    private static boolean isValid(int x, int y, int r, int c) {
        return (x >= 0 && x <= r && y >= 0 && y <= c);
    }

    private static String getFacing(String op, String facing) {
        String[] directions = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};
        int i;
        for (i = 0; i < 8; i++)
            if (facing.equals(directions[i])) {
                break;
            }
        switch (op) {
            case "R": {
                if (i == 6) return "N";
                if (i == 7) return "NE";
                return directions[i + 2];
            }
            case "r": {
                if (i == 7) return "N";
                return directions[i + 1];
            }
            case "L": {
                if (i == 0) return "W";
                if (i == 1) return "NW";
                return directions[i - 2];
            }
            default: {
                if (i == 0) return "NW";
                return directions[i - 1];
            }
        }
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
