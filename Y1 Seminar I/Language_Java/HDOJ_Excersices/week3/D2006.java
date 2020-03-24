package HDOJ.week3;

import java.util.Scanner;

public class D2006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int rounds = sc.nextInt();
            int[] nums = new int[10010];
            for (int i = 0; i < rounds; i++) {
                nums[i] = sc.nextInt();
            }
            int sum=1;
            for (int x: nums){
                if (x % 2 != 0){
                    sum *= x;
                }
            }
            System.out.println(sum);
        }
        sc.close();
    }
}
