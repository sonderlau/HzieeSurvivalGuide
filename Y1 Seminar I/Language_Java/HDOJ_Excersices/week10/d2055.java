package HDOJ.week10;

import java.util.Scanner;

public class d2055 {
    public static void M1(char str,int kk){
        char aa[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for(int i=0;i<26;i++){
            if(aa[i]==str)
                System.out.println((i+1)+kk);
        }
    }
    public static void M2(char str,int kk){
        char aa[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int i=0;i<26;i++){
            if(aa[i]==str)
                System.out.println(-(i+1)+kk);
        }
    }
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int nn=cin.nextInt();
        for(int ii=0;ii<nn;ii++){
            String st=cin.next();
            int kk=cin.nextInt();
            char a[]=st.toCharArray();
            char str=a[0];
            if(str>='a'&&str<='z')
                M2(str,kk);
            else if(str>='A'&&str<='Z')
                M1(str,kk);


        }
    }
}
