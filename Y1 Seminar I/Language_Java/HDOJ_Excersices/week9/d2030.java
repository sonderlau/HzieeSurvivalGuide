package HDOJ.week9;

import java.util.Scanner;

public class d2030 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        while(n-->0){
            String cin=sc.nextLine();
            char []s=cin.toCharArray();
            int a=0;
            for(int i=0;i<s.length;i++){
                // 汉子ASC码大于120 是关键
                if(s[i]>128){
                    a++;
                }
            }
            System.out.println(a);
        }

    }
}
