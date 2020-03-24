package HDOJ.week9;

import java.util.Scanner;

public class d2018 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext())
        {
            int[] s;
            s=new int[1000];
            s[0]=1;
            s[1]=1;
            s[2]=2;
            s[3]=3;
            int n;
            n=in.nextInt();
            if(n==0)
                break;
            for(int i=4;i<=n;i++)
            {
                s[i]=s[i-1]+s[i-3];
            }
            System.out.println(s[n]);
        }


    }
}
