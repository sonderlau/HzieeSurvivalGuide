package HDOJ.week7;

import java.util.Scanner;

public class D1163 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            if (n == 0){
                return;
            }
            int a=n;
            for(int i=2;i<=n;i++){
                a= a* n % 9;
            }

            if(a==0){
                System.out.println("9");
            }

            else{
                System.out.println(a);

            }


        }
    }

    }
