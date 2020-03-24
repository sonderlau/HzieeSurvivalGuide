package HDOJ.week5;

import java.util.Scanner;

public class D1005 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            if (A == B&&  B== C && C==0){
                return;
            }
            int temp =numberSequence(A,B,C);
            System.out.println(temp);

        }
    }
    public static int numberSequence(int A,int B,int n){
        //mod 7 到最后只有49种可能，如果不加这个会导致内存超出限制
        if (n > 49){
            n %= 49;
        }

        if (n == 1 || n == 2) {
            return 1;
        }
        return ((A * numberSequence(A,B,n-1) + B * numberSequence(A, B, n-2)) % 7);
    }
}
