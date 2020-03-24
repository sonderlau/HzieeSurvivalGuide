package HDOJ.week1;

import java.util.Scanner;

public class D1092 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int rounds = sc.nextInt();
            if (rounds == 0){
                return;
            }
            int sum=0;
            for (int r=0;r<rounds;r++){
                int temp = sc.nextInt();
                sum += temp;
            }
            System.out.println(sum);
        }
    }
}
