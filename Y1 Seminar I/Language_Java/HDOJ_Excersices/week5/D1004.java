package HDOJ.week5;

import java.util.Scanner;

public class D1004 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int rounds = sc.nextInt();
            if (rounds == 0){
                continue;
            }
            String[] colors = new String[rounds];
            for (int i = 0; i < rounds; i++) {
                colors[i] = sc.next();
            }
            int count=0,index=0,max=0;
            for (int i = 0; i < rounds; i++) {
                for (int j = i; j < rounds; j++) {
                    if (colors[j].equals(colors[i])){
                        count++;
                    }

                }
                if (count>max){
                    max = count;
                    index=i;
                }
                count =0;
            }
            System.out.println(colors[index]);
        }
        sc.close();
    }
}
