package HDOJ.week9;

import java.util.Scanner;

public class d2025 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.next();
            char[] c=str.toCharArray();
            char max=c[0];
            for(int i=0;i<str.length();i++){
                if(max<c[i])
                    max=c[i];
            }
            for(int i=0;i<str.length();i++){
                System.out.print(c[i]);
                if(max==c[i])
                    System.out.print("(max)");
            }
            System.out.println();
        }
    }
}
