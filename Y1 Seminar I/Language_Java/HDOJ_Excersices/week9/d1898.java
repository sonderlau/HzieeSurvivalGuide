package HDOJ.week9;

import java.util.Scanner;

public class d1898 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t =sc.nextInt();
        while(t-->0){
            int a = sc.nextInt();
            int b =sc.nextInt();
            int tm = sc.nextInt();
            if(tm%a==tm%b){
                System.out.println("Both!");
                continue;
            }
            if(tm%a<tm%b){
                System.out.println("Sempr!");
                continue;
            }
            System.out.println("Xiangsanzi!");
        }
    }
}
