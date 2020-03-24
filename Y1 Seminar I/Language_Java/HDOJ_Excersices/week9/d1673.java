package HDOJ.week9;

import java.util.Scanner;

public class d1673 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int min=sc.nextInt();
            int max = min;
            int m;
            while(n-->1){
                m = sc.nextInt();
                if(m>max){
                    max=m;
                }
                if(m<min){
                    min=m;
                }
            }

            System.out.println(2*(max-min));

        }


    }
}
