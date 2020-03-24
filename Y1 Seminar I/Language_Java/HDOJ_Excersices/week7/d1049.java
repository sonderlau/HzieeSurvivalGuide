package HDOJ.week7;

import java.util.Scanner;

public class d1049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            if (n == 0){
                return;
            }
            int u = sc.nextInt();
            int d = sc.nextInt();

            int time = 0;
            int done = 0;
            while (done < n){
                if ((done + u) >= n){
                    time += 1;
                    break;
                }
                done += u;
                done -= d;
                time += 2;

            }
            System.out.println(time);
        }
    }
}
