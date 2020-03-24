package HDOJ.week3;

import java.util.Scanner;

public class D2004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int temp = sc.nextInt();
            if (temp >100 || temp <0){
                System.out.println("Score is error!");
            }else if (temp <=59){
                System.out.println("E");
            }else if ( temp <=69 ) {
                System.out.println("D");
            }else if (temp <=79){
                System.out.println("C");
            }else if(temp <=89){
                System.out.println("B");
            }else{
                System.out.println("A");
            }
        }
        sc.close();
    }
}
