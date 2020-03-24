package HDOJ.week9;

import java.util.Scanner;

public class d2021 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n==0){break;}
            int[] a=new int [100];
            int x1,x2,x3,x4,x5,x6,sum; int m=0;int z ;
            for(int i = 0;i<=n-1;i++){
                a[i] = sc.nextInt();
                x1=a[i]/100;  x2=(a[i]-100*x1)/50;
                x3=(a[i]-100*x1-50*x2)/10;
                x4=(a[i]-100*x1-50*x2-10*x3)/5;
                x5=(a[i]-100*x1-50*x2-10*x3-5*x4)/2;
                x6=a[i]-100*x1-50*x2-10*x3-5*x4-2*x5;
                sum=x1+x2+x3+x4+x5+x6;
                m = m+sum;
                //  System.out.print(x1+" "+x2+" "+x3+" "+x4+" "+x5+" "+x6+" ");
                //   z = 100*x1+50*x2+10*x3+5*x4+2*x5+1*x6;
                //  System.out.println(z);
            }
            System.out.println(m);
        }
    }
}
