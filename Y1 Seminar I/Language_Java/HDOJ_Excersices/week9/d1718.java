package HDOJ.week9;

import java.util.Scanner;

public class d1718 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int jack = sc.nextInt();
            int jackMark = 0;
            int number = 0;
            int mark[] = new int[1001];
            int i = 0;
            while (true) {
                number = sc.nextInt();
                mark[i] = sc.nextInt();
                if (number == 0 && mark[i] == 0) {
                    break;
                }
                if (number == jack) {
                    jackMark = mark[i];
                }
                i++;
            }
            int k = 1;
            for (int j = 0; j < i; j++) {
                if (mark[j] > jackMark) {
                    k++;
                }
            }
            System.out.println(k);
        }
        sc.close();
    }
}
