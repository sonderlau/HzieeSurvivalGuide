package HDOJ.week6;


import java.util.Scanner;

public class D1037 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=168;
        while(in.hasNext()) {
            int [] a =new int [3];
            int flag = -1;
            for(int i=0;i<a.length;i++) {
                a[i]=in.nextInt();
                if(a[i]<=n) {
                    flag=i;
                }
            }
            if(flag==-1) {
                System.out.println("NO CRASH");
            } else {
                System.out.println("CRASH "+a[flag]);
            }
        }
        in.close();
    }
}
