package HDOJ.week2;

import java.math.BigInteger;
import java.util.Scanner;

public class D1002 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int rounds = sc.nextInt();
        for (int i=0;i<rounds;i++){
            BigInteger a =sc.nextBigInteger();
            BigInteger b =sc.nextBigInteger();

            BigInteger bi = new BigInteger(String.valueOf(a));
            System.out.println("Case "+(i+1)+":");
            System.out.println(a + " + " + b  + " = " + bi.add(b));
            if ((rounds-i) != 1){
                System.out.println();
            }
        }
        sc.close();



    }
}
