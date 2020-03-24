package HDOJ.week9;

import java.util.Scanner;

public class d1418 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            long n = sc.nextLong();
            long m = sc.nextLong();
            if(n==0&&m==0){
                return;
            }
            System.out.println(n+m-2);
        }
    }
}
