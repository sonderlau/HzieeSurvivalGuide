package HDOJ.week6;

import java.util.Scanner;

public class D1017 {
    private static Scanner in = new Scanner(System.in);
    public static boolean judge(int a,int b,int m) {
        int sum = a*a + b*b + m;
        int cap = a*b;
        if(sum%cap==0)
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        int N = in.nextInt();
        for(int time = 1;time <=N;time++)
        {
            int cnt = 1;
            while(in.hasNext())
            {
                int count = 0;
                int n = in.nextInt();
                int m = in.nextInt();
                if(n==0 && m==0) {
                    break;
                }
                for(int a = 1;a < n;a++) {
                    for(int b = a+1;b < n;b++) {
                        if(judge(a,b,m)) {
                            count++;
                        }
                    }
                }
                System.out.println("Case "+cnt+": "+count);
                cnt++;
            }
            if(time!=N) {
                System.out.println();
            }
        }
    }
}
