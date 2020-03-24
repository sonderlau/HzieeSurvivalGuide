package HDOJ.week9;

import java.util.Scanner;

public class d2022 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            int flag=0;//记录分数
            int flag1=0;//记录行
            int flag2=0;//记录列
            int a[][] = new int[m][n];
            for (int i = 0; i < a.length; i++)
                for (int j = 0; j < a[i].length; j++) {
                    a[i][j] = in.nextInt();
                }
            flag=a[0][0];
            for (int i = 0; i < a.length; i++)
                for (int j =0; j < a[i].length; j++) {
                    if(Math.abs(flag)<Math.abs(a[i][j])){
                        flag=a[i][j];
                        flag1=i+1;
                        flag2=j+1;
                    }
                }
            System.out.println(flag1+" "+flag2+" "+flag);
        }
    }
}
