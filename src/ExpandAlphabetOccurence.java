import java.util.Scanner;
import static java.lang.Character.*;
public class ExpandAlphabetOccurence extends Thread {
    public static void main(String[] a) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.next();
        int l = ip.length(), i,j,m;
        for(i=0;i<l-1;){
            StringBuilder digit= new StringBuilder();StringBuilder str= new StringBuilder();
            if (isDigit(ip.charAt(i))) {
                while (i<l && isDigit(ip.charAt(i))){
                    digit.append(ip.charAt(i));i++;
                }
                while(i<l && !isDigit(ip.charAt(i))){
                    str.append(ip.charAt(i));
                    i++;
                }
            } else {
                while(i<l && !isDigit(ip.charAt(i))){
                    str.append(ip.charAt(i));
                    i++;
                }
                while (i<l && isDigit(ip.charAt(i))){
                    digit.append(ip.charAt(i));i++;
                }
            }
            if((digit.length() > 0) && (str.length() > 0)){
                int n=Integer.parseInt(digit.toString()),k=str.length();
                for(m=0;m<k;m++){
                    for(j=0;j<n;j++){
                        System.out.print(str.charAt(m));
                    }
                }
            }
        }
    }
}