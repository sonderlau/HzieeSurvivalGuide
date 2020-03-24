package HDOJ.week9;

import java.util.Scanner;

public class d1587 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();

            int min = sc.nextInt();
            a--;
            int t;
            while(a-->0){
                t = sc.nextInt();
                if(t<min){
                    min=t;
                }
            }
            System.out.println(b/min);
        }
    }
}
