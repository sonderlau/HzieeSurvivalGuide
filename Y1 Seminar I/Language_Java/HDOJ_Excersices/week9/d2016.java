package HDOJ.week9;

import java.util.Scanner;

public class d2016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                continue;
            }
            int nums[] = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            // 找出最小的元素
            int mark = 0;
            int min = nums[0];
            for (int i = 0; i < n; i++) {
                if (nums[i] < min) {
                    min = nums[i];
                    mark = i;
                }
            }
            // 交换
            int temp = nums[mark];
            nums[mark] = nums[0];
            nums[0] = temp;
            // 输出
            for (int i = 0; i < n; i++) {
                if (i != n - 1) {
                    System.out.print(nums[i] + " ");
                } else {
                    System.out.print(nums[i]);
                }
            }
            System.out.println();
        }
    }
}
