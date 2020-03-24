package HDOJ.week10;

import java.util.Scanner;

public class d2053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();

            int k =0;
            for(int i=1;i<=n;i++){
                if(n%i==0){
                    k++;
                }
            }

            if(k%2==0){
                System.out.println("0");
            }else{
                System.out.println("1");
            }


        }

    }
}
