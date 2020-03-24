package HDOJ.week9;

import java.util.Scanner;

public class d1877 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int m  =sc.nextInt();
            if(m==0){
                return ;
            }
            int a = sc.nextInt();
            int b = sc.nextInt();
            String s = (a+b)+"";
            System.out.println( Integer.toString(a+b, m) );
        }
    }
}
