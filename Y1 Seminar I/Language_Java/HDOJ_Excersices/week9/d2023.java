package HDOJ.week9;

import java.util.Scanner;

public class d2023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            double ave = 0;
            double ave2 = 0;
            int count = 0;
            int count2 = 0;
            int t = 0;
            double save[] = new double[m];
            double save1[] = new double[n];
            int arr[][] = new int[50][5];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    ave += arr[i][j];
                    count++;
                    if (count == m) {
                        save1[i] = ave / m;
                        if (i == 0) {
                            System.out.printf("%.2f", save1[i]);
                        } else {
                            System.out.printf(" " + "%.2f", save1[i]);
                        }
                        ave = 0;
                        count = 0;
                    }
                }
            }
            System.out.println();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ave2 += arr[j][i];
                    count2++;
                    if (count2 == n) {
                        save[i] = ave2 / n;
                        if (i == 0) {
                            System.out.printf("%.2f", save[i]);
                        } else {
                            System.out.printf(" " + "%.2f", save[i]);
                        }

                        ave2 = 0;
                        count2 = 0;
                    }
                }
            }

            System.out.println();

            int count3 = 0;
            int q = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if (arr[i][j] >= save[j]) {
                        count3++;
                    }
                }

                if (count3 == m) {
                    q++;
                }
                count3 = 0;
            }
            System.out.println(q);
            System.out.println("");

        }

    }
}
