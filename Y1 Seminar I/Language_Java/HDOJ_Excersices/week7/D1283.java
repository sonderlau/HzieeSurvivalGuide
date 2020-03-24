package HDOJ.week7;

import java.util.Scanner;

public class D1283 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int M1=0, M2=0, R1=0, R2=0, R3=0;
            M1 = sc.nextInt();
            M2 = sc.nextInt();
            String commands = sc.next();
            for (int i = 0; i < commands.length(); i++) {
                switch (commands.charAt(i)) {
                    case 'A':
                        R1 = M1;
                        break;
                    case 'B':
                        R2 = M2;
                        break;
                    case 'C':
                        M1 = R3;
                        break;
                    case 'D':
                        M2 = R3;
                        break;
                    case 'E':
                        R3 = R1 + R2;
                        break;
                    case 'F':
                        R3 = R1 - R2;
                        break;
                }

            }
            System.out.println(M1 + "," + M2);
        }
    }
}


