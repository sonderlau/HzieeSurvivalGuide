package HDOJ.week2;

import java.util.Scanner;

public class D1094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int rounds = sc.nextInt();
            int sum=0;
            for (int r=0;r<rounds;r++){
                int temp = sc.nextInt();
                sum += temp;
            }
            System.out.println(sum);
        }
    }
}
