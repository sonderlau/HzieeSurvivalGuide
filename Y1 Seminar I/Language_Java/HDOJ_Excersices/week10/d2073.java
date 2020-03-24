package HDOJ.week10;

import java.util.Scanner;

public class d2073 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-->0){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            double numbers =Math.abs( answer(x1,y1)-answer(x2,y2)  );

            System.out.printf("%.3f",numbers);
            System.out.println();

        }
    }

    private static double answer(int x, int y) {
        double t = Math.sqrt(2);
        double ans = 0.0;
        for(int i=1;i<x+y;i++)
            ans+=t*i;
        ans =ans+t*x;
        for(int i=0;i<x+y;i++)
            ans =ans+Math.sqrt(i*i+(i+1)*(i+1));

        return ans;
    }
}
