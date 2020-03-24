package HDOJ.week10;


import java.io.BufferedInputStream;
import java.util.Scanner;

public class d2035 {
    public static void main(String args[]){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            if(n == 0 && m == 0){
                break;
            }
            int t=1;
            for(int i=0;i<m;i++){
                t =t*n%1000;
            }
            System.out.println(t);
        }
    }
}
