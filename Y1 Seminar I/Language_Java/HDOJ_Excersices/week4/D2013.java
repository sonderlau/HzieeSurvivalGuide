package HDOJ.week4;

import java.util.Scanner;

public class D2013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int temp = sc.nextInt();
            System.out.println(solve(temp));


        }
        sc.close();
    }
    public static int solve(int day){
        int result=1;
        for (int i = 2; i <= day; i++) {
            result = (result+1)*2;
        }
        return result;
    }

}
