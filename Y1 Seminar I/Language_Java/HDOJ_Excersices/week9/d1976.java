package HDOJ.week9;

import java.util.Scanner;

public class d1976 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int a[] = new int[3];
            int b[] = new int[3];
            for (int i = 0; i < a.length; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < b.length; i++) {
                b[i] = sc.nextInt();
            }
            boolean boo = true;
            for (int i = 0; i < b.length; i++) {
                if (a[i]>b[i]) {
                    System.out.println("First");
                    boo = false;
                    break;
                }
                if (a[i]<b[i]) {
                    System.out.println("Second");
                    boo = false;
                    break;
                }
            }
            if (boo) {
                System.out.println("Same");
            }
        }
        sc.close();
    }
}
