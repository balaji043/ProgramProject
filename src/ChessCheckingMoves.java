import java.util.Scanner;

public class ChessCheckingMoves {
    private static char[][] chessBoard = new char[8][8];
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String FEN, borw;
        int s, i = 0, j = 0;
        int Rr = -1, Rc = -1, Kr = -1, Br = -1;
        int Bc = -1, Qr = -1, Nr = -1, Nc = -1;
        int KRClearFlag = 0, WCClearFLag = 0;
        int KCClearFlag = 0, WRCClearFlag = 0;
        int rank;
        String file="abcdefgh";
        FEN = scanner.next();
        for (s=0;s<FEN.length()-1;s++){
            if(FEN.charAt(s)!='/'){
                if(FEN.charAt(s)=='1'||FEN.charAt(s)=='2'||FEN.charAt(s)=='3'||FEN.charAt(s)=='4'||
                        FEN.charAt(s)=='5'||FEN.charAt(s)=='6'||FEN.charAt(s)=='7'||FEN.charAt(s)=='8'){
                    for (j=0;j<Character.getNumericValue(FEN.charAt(s)-48);j++){
                        chessBoard[0][i] = ' ';
                        i++;
                    }
                }else {
                    chessBoard[0][i] = FEN.charAt(s);
                    i++;
                }
            }

        }
        for (i=0;i<8;i++){
            for (j=0;j<8;j++){
                System.out.print("|"+chessBoard[i][j]);
            }
            System.out.println();
        }
    }
}
/*

rnbqkbnr/pppppppp/8/8/8/pppppppp/RNBQKBNR

*/
