package HDOJ.week2;

import java.util.Scanner;

public class D1096 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Rounds = sc.nextInt();
        for (int R = 0;R<Rounds;R++){
            int rounds = sc.nextInt();
            int sum=0;
            for (int r=0;r<rounds;r++){
                int temp = sc.nextInt();
                sum += temp;
            }
            System.out.println(sum);
            if (R-Rounds != -1){
                System.out.println();
            }


        }
        sc.close();
    }
}
