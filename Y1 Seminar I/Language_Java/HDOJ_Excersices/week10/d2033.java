package HDOJ.week10;

import java.util.Scanner;

public class d2033 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n-->0){
            int ah=sc.nextInt();
            int am=sc.nextInt();
            int as=sc.nextInt();
            int bh=sc.nextInt();
            int bm=sc.nextInt();
            int bs=sc.nextInt();
            bs+=as;
            bh+=ah;
            bm+=am;
            if(bs>59){
                bm++;
                bs-=60;
            }
            if(bm>59){
                bh++;
                bm-=60;
            }
            System.out.println(bh+" "+bm+" "+bs);
        }
    }
}
