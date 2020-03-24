package HDOJ.week7;

import java.util.Scanner;

public class D1164 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            for(int i=2;i*i<=n;i++)
            {
                if(n%i==0)
                {
                    n=n/i;
                    System.out.printf("%d*",i);
                    i=1;
                }
            }
            System.out.printf("%d",n);
            System.out.println();
       }
    }
}
