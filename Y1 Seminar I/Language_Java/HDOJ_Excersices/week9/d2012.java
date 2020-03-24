package HDOJ.week9;

import java.util.Scanner;

public class d2012 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x==0&&y==0)
                return ;
            int flag = 0;
            for(int i=x;i<=y;i++){
                if(!susu(i*i+i+41)){
                    System.out.println("Sorry");
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                System.out.println("OK");
        }
    }
    private static boolean susu(int n){
        //判断n是否是素数，是素数返回true
        for(int i=2;i*i<=n;i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
}
