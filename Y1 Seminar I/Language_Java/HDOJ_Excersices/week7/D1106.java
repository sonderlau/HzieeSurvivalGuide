package HDOJ.week7;

import java.util.Arrays;
import java.util.Scanner;

public class D1106 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            String[] nice = str.split("5");
            int[] num = new int[nice.length];
            Arrays.fill(num,-1);
            for (int i = 0; i < nice.length; i++) {
                if (!"".equals(nice[i])){
                    num[i] = Integer.parseInt(nice[i]);
                }

                
            }
            Arrays.sort(num);
            for (int i = 0; i < num.length-1; i++) {
                if (num[i] != -1){
                    System.out.print(num[i] + " ");
                }

            }
            System.out.print(num[num.length-1]);
            System.out.println();
        }

        sc.close();
    }
}
