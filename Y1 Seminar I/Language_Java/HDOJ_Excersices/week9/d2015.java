package HDOJ.week9;

import java.util.Scanner;

public class d2015 {
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        while(cin.hasNext()){
            int m=cin.nextInt();
            int n=cin.nextInt();
            int k=m/n;
            for(int i=0;i<k;i++){
                int sum=0;
                for(int j=i*n;j<(i+1)*n;j++){
                    sum+=(2*(j+1));
                }
                sum=sum/n;
                if(i<k-1)
                    System.out.print(sum+" ");
                else
                    System.out.print(sum);
            }

            if(m%n!=0){
                int sum1=0;
                for(int i=1;i<=m%n;i++){
                    sum1+=2*(n*k+i);
                }
                sum1=sum1/(m-n*k);
                System.out.print(" "+sum1);
            }
            System.out.println();
        }
    }
}
