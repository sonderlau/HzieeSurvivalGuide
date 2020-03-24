package HDOJ.week10;

import java.util.Scanner;

public class d2032 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int a[][]=new int[n][];
            for(int i=0;i<n;i++){
                a[i]=new int[i+1];
                for(int j=0;j<=i;j++){
                    if(j==0||j==i){
                        a[i][j]=1;	//令边上的全为1
                    }else{
                        a[i][j]=a[i-1][j-1]+a[i-1][j];

                        //中间的为上一行上一列+上一行这一列
                    }
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<=i;j++){
                    if(j==i){
                        System.out.println(a[i][j]);
                    }else{
                        System.out.print(a[i][j]+" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
