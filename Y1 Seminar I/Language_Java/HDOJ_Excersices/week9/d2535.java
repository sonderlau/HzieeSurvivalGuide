package HDOJ.week9;

import java.util.Arrays;
import java.util.Scanner;

public class d2535 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n =sc.nextInt();
            if(n==0){
                return ;
            }
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            Arrays.sort(a);
            int sum=0;
            for(int i=0;i<(int)(n/2)+1;i++){
                sum+=(int)(a[i]/2)+1;
            }
            System.out.println(sum);
        }
    }
}
