package HDOJ.week1;

import java.util.Scanner;

public class D1001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int num = sc.nextInt();
            int sum = 0;
            for (int i=1;i<=num;i++){
                sum += i;
            }
            System.out.println(sum);
            System.out.println(); // 坑爹
        }
        sc.close();
    }
}
