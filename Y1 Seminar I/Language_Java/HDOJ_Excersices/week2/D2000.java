package HDOJ.week2;

import java.util.Arrays;
import java.util.Scanner;

public class D2000 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            int[] chars = new int[3];
            chars[0] = str.charAt(0);
            chars[1] = str.charAt(1);
            chars[2] = str.charAt(2);
            Arrays.sort(chars);
            char a = (char) chars[0];
            char b = (char) chars[1];
            char c = (char) chars[2];
            System.out.println(a+" "+b+" "+c);
        }
        sc.close();
    }
}
