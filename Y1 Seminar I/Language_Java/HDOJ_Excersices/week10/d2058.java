package HDOJ.week10;

import java.util.Scanner;

public class d2058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(m==0&&n==0){
                return ;
            }

            int j =(int)Math.pow(2.0*m, 0.5);
            for(j=j;j>0;j--){
                int i;
                i = (2*m/j-j+1)/2;
                if(j*(j+2*i-1)/2==m){
                    System.out.println("["+i+","+(i+j-1)+"]");
                }
            }
            System.out.println();
        }
    }
}
