package HDOJ.week10;

import java.util.Scanner;

public class d2060 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            int numball = sc.nextInt();
            int A =sc.nextInt();
            int B =sc.nextInt();
            int piont = 0;
            if(numball>21||numball<0){
                break;
            }
            if(numball<7){
                int x=7;
                for(int i=0;i<numball;i++){
                    piont=piont+x;x--;
                }
            }else{
                piont = (numball-6)*8+27;
            }
            if((A+piont)>=B){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }

        }
    }
}
