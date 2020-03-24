package HDOJ.week6;

import java.util.Arrays;
import java.util.Scanner;

public class D1040 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int T = sc.nextInt();
            for (int i = 0; i < T; i++) {
                int n = sc.nextInt();
                int nums[] = new int[n];
                // 填充数组
                for (int j = 0; j < n; j++) {
                    nums[j] = sc.nextInt();
                }
                Arrays.sort(nums);
                // 输出
                for (int j = 0; j < n; j++) {
                    if (j != n - 1) {
                        System.out.print(nums[j] + " ");
                    } else {
                        System.out.println(nums[j]);
                    }
                }
            }
        }
    }
}
