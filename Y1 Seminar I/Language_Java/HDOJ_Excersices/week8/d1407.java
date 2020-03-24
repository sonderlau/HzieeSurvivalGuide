package HDOJ.week8;

import java.util.Scanner;

public class d1407 {
    public static void main(String argv[]){
        Scanner cin = new Scanner(System.in);
        int [] a = new int[10005];
        int [] routei = new int[10005];
        int [] routej = new int[10005];
        int [] routek = new int[10005];
        int [] b = new int[105];
        for(int i = 1 ; i <= 100 ; i++) {
            b[i] = i * i;
        }
        for(int i = 1 ; i <= 10000 ; i ++) a[i] = 0;
        for(int i = 1 ; i <= 100 ; i++) {
            for(int j = i ; j <= 100 ; j ++) {
                if(b[i] + b[j] > 10000) break;
                for(int k = j ; k <= 100 ; k++) {
                    final int i1 = b[i] + b[j] + b[k];
                    if(i1 > 10000) break;
                    if(a[i1] == 1) continue;
                    a[i1] = 1;
                    routei[i1] = i;
                    routej[i1] = j;
                    routek[i1] = k;
                }
            }
        }
        int n ;
        while(cin.hasNext()){
            n = cin.nextInt();
            System.out.printf("%d %d %d\r\n",routei[n],routej[n],routek[n]);
        }
    }
}
