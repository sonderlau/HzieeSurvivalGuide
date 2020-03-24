package HDOJ.week1;

import java.util.Scanner;

public class D1091 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a==0&&b==0){
                return;
            }
            System.out.println(a+b);
        }
    }
}
