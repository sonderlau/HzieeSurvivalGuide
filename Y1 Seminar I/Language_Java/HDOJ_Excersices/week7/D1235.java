package HDOJ.week7;

import java.util.Scanner;

public class D1235 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            if (n == 0){
                return;
            }
            int[] scores = new int[n];
            for (int i = 0; i < n; i++) {
                scores[i] = sc.nextInt();

            }
            int standard = sc.nextInt();
            int count = 0;
            for (int i : scores){
                if ( i == standard ){
                    count ++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
