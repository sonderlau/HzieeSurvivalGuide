package HDOJ.week9;

import java.util.Scanner;

public class d2029 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        while (n-->0){
            String str=in.next();
            String str1=reverse(str);
            if(str.equals(str1))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

    public static String reverse(String str)
    {
        return new StringBuffer(str).reverse().toString();
    }
}
