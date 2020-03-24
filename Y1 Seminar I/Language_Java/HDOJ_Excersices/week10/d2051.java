package HDOJ.week10;

import java.util.Scanner;

public class d2051 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int N=sc.nextInt();
            int R=2;
            if(N<0){N=-N;System.out.print("-");}
            int x=N/R;int y=N%R;
            char chs[]={'0','1'};
            int []a=new int [50];int i=0;
            a[0]=N%R;
            while(x!=0){
                i++;
                y=x%R; a[i]=y;
                x=x/R;
            }
            int b[]=new int[i+1];
            for(int k=0;k<i+1;k++){
                // System.out.print(a[k]+" a");
                b[k]=a[i-k];
                //System.out.print(b[k]+" ");
            }
            for(int j=0;j<b.length;j++){

                System.out.print(chs[b[j]]);
            }
            System.out.println();
        }
    }
}
