package HDOJ.week10;

import java.util.Scanner;

public class d2061 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-->0){

            int m = sc.nextInt();
            String str = "" ;
            int c =0;
            int s = 0;
            boolean isSorry = false;
            double num1=0;
            double num2=0;
            double a=0;
            double b=0;
            for(int i=0;i<m;i++){
                str = sc.next();
                a=sc.nextDouble();
                b=sc.nextDouble();
                if(b<60){
                    isSorry = true;
                }else{
                    num1 = num1+a*b;
                    num2 = num2 +a;
                }
            }
            if(isSorry){
                System.out.println("Sorry!");
            }else{
                System.out.printf("%.2f",num1/num2);
                System.out.println();
            }
            if(t!=0){
                System.out.println();
            }
        }
    }
}
