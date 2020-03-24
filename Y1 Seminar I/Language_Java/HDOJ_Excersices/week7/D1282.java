package HDOJ.week7;

import java.util.Scanner;

public class D1282 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n =sc.nextInt();
            String str = n+"";
            StringBuilder strs = new StringBuilder();
            String strn = n+"";
            for(int i=str.length()-1;i>=0;i--){
                strs.append(str.charAt(i));
            }

            int n2=Integer.parseInt(strs.toString());
            int time=0;
            while(!ishui(str)){
                n=n+n2;
                str=""+n;
                strs = new StringBuilder();
                //必须把strs赋为空
                for(int i=str.length()-1;i>=0;i--){
                    strs.append(str.charAt(i));
                }
                n2=Integer.parseInt(strs.toString());
                strn=strn+"--->"+str;
                time++;
            }
            System.out.println(time);
            System.out.println(strn);
        }
    }

    private static boolean ishui(String str) {
        boolean isFalg = true;
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }

}
