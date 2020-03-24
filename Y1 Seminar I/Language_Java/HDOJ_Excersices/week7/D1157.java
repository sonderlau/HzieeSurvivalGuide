package HDOJ.week7;

import java.util.Arrays;
import java.util.Scanner;

public class D1157 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int rounds = sc.nextInt();
            int[] nums = new int[rounds];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            int resuleIndex = nums.length/2 ;
            System.out.println(nums[resuleIndex]);
        }

        sc.close();
    }
}
