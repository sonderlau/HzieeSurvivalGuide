package HDOJ.week7;

import java.util.Scanner;

public class D1219 {
    public static void main(String args[]) {
        Scanner scan=new Scanner(System.in);
        String str;
        int a[]=new int[26];
        while(scan.hasNext()){
            str=scan.nextLine();
            char b[]=str.toCharArray();
            for(int i=0;i<26;i++){
                a[i]=0;
            }
            for(int i=0;i<b.length;i++){
                if(b[i]>='a'&&b[i]<='z'){
                    a[b[i]-'a']++;
                }
            }
            for(int i=0;i<26;i++){
                System.out.println((char)('a'+i)+":"+a[i]);
            }
            System.out.println();
        }

    }
    }

