package HDOJ.week9;

import java.util.Scanner;

public class d2019 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in =new Scanner(System.in);
        while(in.hasNext())
        {
            int n,m;
            int i;
            n=in.nextInt();
            m=in.nextInt();
            if(n==0&&m==0)
                break;
            int[] s;
            s=new int[110];
            int[] b;
            b=new int[110];
            for( i=0;i<n;i++)
            {
                s[i]=in.nextInt();
            }
            for( i=0;i<n;i++)
            {
                if(m>s[i])
                {
                    b[i]=s[i];
                }
                else
                {
                    b[i]=m;
                    break;
                }
            }
            for(;i<n+1;i++)
            {
                b[i+1]=s[i];
            }
            for(i=0;i<n;i++)
            {
                System.out.printf("%d ",b[i]);
            }
            System.out.println(b[n]);
        }

    }
}
