package HDOJ.week10;

import java.util.Arrays;
import java.util.Scanner;

public class d2078 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int s[] = new int[n];
            for(int i=0;i<n;i++){
                s[i] = sc.nextInt();
            }
            Arrays.sort(s);
            System.out.println((100-s[0])*(100-s[0]));
        }
    }
}
