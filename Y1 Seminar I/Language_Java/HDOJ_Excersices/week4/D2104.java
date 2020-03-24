package HDOJ.week4;

import java.util.Arrays;
import java.util.Scanner;

public class D2104 {
    public static void main(String[] args) {
        // 本质就是求是否互质
        Scanner sc = new Scanner(System.in);
        while(true){
            int N = sc.nextInt();
            int M = sc.nextInt();
            if (N == -1 && M == -1){
                break;
            }
            if (gcd(N,M) == 1){
                System.out.println("YES");
            }else {
                System.out.println("POOR Haha");
            }


        }
    }
    public static int gcd(int m, int n) {

        if (m < n) {
            // 保证m>n,若m<n,则进行数据交换
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {
            // 在余数不能为0时,进行循环
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;
        // 返回最大公约数
    }



}

