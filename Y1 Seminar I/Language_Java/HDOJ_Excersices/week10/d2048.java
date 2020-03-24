package HDOJ.week10;

import java.util.Scanner;

public class d2048 {
    public static void main(String[] args) {
        double[] key = new double[21];
        key[0]=0;
        key[1]=0;
        key[2]=1;
        for(int i=3;i<21;i++){
            key[i] = (i-1)*(key[i-1]+key[i-2]);
        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            int m = sc.nextInt();

            for(int i=1;i<=m;i++){
                key[m]=key[m]/i;
            }

            System.out.printf("%.2f",(key[m]*100));
            System.out.println("%");
        }


    }
}
