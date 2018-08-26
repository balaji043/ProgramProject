import java.util.Scanner;

public class N2_Occurence_In_N1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), m = s.nextInt(),l=0,cmp=0, i, count = 0;
        i = m;
        while(i>0){
            i=i/10;
            l++;
        }

        double d=Math.pow(10,l);
        int div=(int)d;
        while(n>0){
            cmp = n % div;
            if(cmp==m){
                count++;
            }
            n=n/div;
        }
        System.out.print(count);

    }
}
