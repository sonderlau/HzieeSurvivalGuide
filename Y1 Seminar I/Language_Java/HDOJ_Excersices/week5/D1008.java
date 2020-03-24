package HDOJ.week5;

import java.util.Scanner;

public class D1008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int rounds = sc.nextInt();
            if (rounds==0 ){
                return;
            }

            int[] floors = new int[rounds];
            for (int i = 0; i < rounds; i++) {
                floors[i] = sc.nextInt();
            }
            System.out.println(calculate(floors));

        }
        sc.close();
    }
    private static int calculate(int[] nice){
        int up = 6, down = 4,stay = 5;
        int sum=0;
        for (int i = 0; i < nice.length; i++) {
            if (i == 0){
                sum = (nice[i]*up + stay);
            }else if (nice[i] - nice[i-1] >= 0){
                sum +=( (nice[i] - nice[i-1])*up + stay);
            }else if (nice[i] - nice[i-1] <0){
                sum += (-1*(nice[i] - nice[i-1])*down + stay);
            }
        }
        return sum;
    }
}
