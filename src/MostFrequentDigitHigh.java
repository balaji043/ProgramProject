import  java.util.*;

public class MostFrequentDigitHigh {

    public static void main(String args[])
    {
        Scanner S = new Scanner(System.in);
        int a = S.nextInt();
        int b = S.nextInt();
        int c = S.nextInt();
        int d = S.nextInt();
        System.out.print(MostFrequentDigit(a,b,c,d));
    }

    private static int MostFrequentDigit(int input1,int input2,int input3,int input4){
        int d ;
        char ch='\0';
        int max=0,ma;
        String st = ""+input1+input2+input3+input4;
        TreeSet<Character> ts = new TreeSet<>(Collections.reverseOrder());
        for(int i=0;i<st.length();i++)
        {
            ts.add(st.charAt(i));
        }
        Iterator<Character> i = ts.iterator();
        while(i.hasNext())
        {
            char cc = i.next();
            ma=0;
            for(int j=0;j<st.length();j++)
            {
                if(cc==st.charAt(j))
                {
                    ma++;
                }
            }
            if(ma>max)
            {
                max = ma;
                ch = cc;
            }
        }
        d = Character.getNumericValue(ch);
        return d;

    }
}