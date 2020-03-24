package HDOJ.week5;

import java.util.Scanner;

public class D1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
             if (sc.nextInt() %4 ==2){
                 System.out.println("yes");
             }else {
                 System.out.println("no");
             }
        }
    }

}
