package HDOJ.week9;

import java.util.Arrays;
import java.util.Scanner;

public class d1678 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<a.length;i++){
                a[i]=sc.nextInt();
            }

            Arrays.sort(a);


            int num=0;

            for(int i=a.length-1-2;i>=n%3;i=i-3){
                num=num+a[i];
            }
            System.out.println(num);

        }

    }
}
