package HDOJ.week4;

import java.util.Scanner;

public class D1062 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String n = sc.nextLine();
            String str[] = n.split(" ");
            for (int i = 0; i < str.length; i++) {
                char a[] = str[i].toCharArray();
                for (int j = a.length - 1; j >= 0; j--) {
                    System.out.print(a[j]);
                }
                if (i != str.length - 1) {
                    System.out.print(" ");
                }
            }
            if (n.charAt(n.length() - 1) == ' ') {
                System.out.println(' ');
            } else {
                System.out.println();
            }
        }


    }


}
