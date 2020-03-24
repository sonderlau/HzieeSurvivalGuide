package HDOJ.week3;

import java.util.Scanner;

public class D2008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int ponum = 0,nenum = 0,zero =0;
            int rounds = sc.nextInt();
            if (rounds == 0){
                return;
            }
            for (int i=0 ; i < rounds ; i++){

                double temp = sc.nextDouble();
                if (temp == 0){
                    zero++;
                } else if (temp > 0) {
                    ponum ++;
                }else {
                    nenum ++;
                }

            }
            System.out.println(nenum + " " + zero + " " + ponum);
        }
        sc.close();
    }
}
