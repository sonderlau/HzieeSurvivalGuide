package HDOJ.week9;

import java.util.Scanner;

public class d1555 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            int k = sc.nextInt();
            if(m==0&&k==0){
                return ;
            }
            int day=0;
            int kt=0;

            while(m>0){
                m--;
                day++;
                kt++;
                if(kt==k){
                    kt=0;
                    m++;
                }
            }
            System.out.println(day);
        }

    }
}
