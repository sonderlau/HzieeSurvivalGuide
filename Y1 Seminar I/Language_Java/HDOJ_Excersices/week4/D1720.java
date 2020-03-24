package HDOJ.week4;

import java.util.Scanner;

public class D1720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String a = sc.next();
            String b = sc.next();
            System.out.println(Integer.parseInt(a,16)+Integer.parseInt(b,16));

        }
        sc.close();
    }
}
