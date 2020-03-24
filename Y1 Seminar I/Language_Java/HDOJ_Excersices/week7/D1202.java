package HDOJ.week7;

import java.text.DecimalFormat;
import java.util.Scanner;

public class D1202 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n;
        while(in.hasNext())
        {
            n=in.nextInt();
            float a,b,count=0,sum1 = 0;
            for(int i=0;i<n;i++)
            {
                a=in.nextFloat();
                b=in.nextFloat();
                if(b==-1) continue;
                count+=a;
                if(b>=90)
                    sum1+=a*4;
                else if(b>=80)
                    sum1+=a*3;
                else if(b>=70)
                    sum1+=a*2;
                else if(b>=60)
                    sum1+=a;

            }
            if(count==0)
                System.out.println("-1");
            else
                System.out.printf("%.2f\n ",sum1/count);
        }
    }
}
