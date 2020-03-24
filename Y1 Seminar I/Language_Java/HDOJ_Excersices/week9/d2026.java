package HDOJ.week9;

import java.util.Scanner;

public class d2026 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String sr = sc.nextLine();
            char []s=sr.toCharArray();
            s[0]=z(s[0]);
            // char []s=sr.toCharArray();
            for(int i=0;i<s.length;i++){
                if(s[i]==' '){
                    s[i+1]=z(s[i+1]);
                }
            }
            print(s);
            System.out.println();
        }
    }
    public static char z(char a){
        int x=(int)a-32;
        char y=(char)x;
        return y;
    }
    public static void print(char []s){
        for(int i=0;i<s.length;i++){
            System.out.print(s[i]);
        }
    }
}
