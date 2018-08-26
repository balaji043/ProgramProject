import java.util.Scanner;

public class FrequentChar {
    public static void main(String []a){
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();

        int count=0,max=0;char ans='a',c;
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            count=0;
            if(Character.isLetter(c)){
                for(int j=i;j<s.length();j++){
                    if(c==s.charAt(j)){
                        count++;
                    }
                }
                if(count>max){
                    max = count;
                    ans=c;
                }
            }
        }

        System.out.println(ans);
    }
}
