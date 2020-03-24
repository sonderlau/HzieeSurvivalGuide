package HDOJ.week9;

import java.util.Arrays;
import java.util.Scanner;

public class d1412 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] narr = new int[n];
            int[] marr = new int[m];
            for (int i = 0; i < n; i++)
                narr[i] = in.nextInt();
            for (int i = 0; i < m; i++)
                marr[i] = in.nextInt();

            Arrays.sort(narr);
            Arrays.sort(marr);
            int nid = 0;
            int mid = 0;
            while (nid < n && mid < m) {
                if (narr[nid] < marr[mid])
                    System.out.print(narr[nid++]);
                else if (narr[nid] > marr[mid]) {
                    System.out.print(marr[mid++]);
                } else {
                    //相等
                    System.out.print(marr[mid++]);
                    nid++;
                }
                if (nid < n || mid < m)
                    System.out.print(" ");
            }
            if (nid == n) {
                for (int i = mid; i < m; i++) {
                    System.out.print(marr[i]);
                    if (i != m - 1)
                        System.out.print(" ");
                }
            } else {
                for (int i = nid; i < n; i++) {
                    System.out.print(narr[i]);
                    if (i != n - 1)
                        System.out.print(" ");
                }
            }
            System.out.println();

        }

    }
}
