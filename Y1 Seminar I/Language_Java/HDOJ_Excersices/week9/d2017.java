package HDOJ.week9;

import java.util.Scanner;

public class d2017 {
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);

        while(cin.hasNext()){
            int n=cin.nextInt();
            for(int i=0;i<n;i++){
                String a=cin.next();
                char [] s=a.toCharArray();
                int sum=0;
                for(int j=0;j<s.length;j++){
                    if(s[j]>='0'&&s[j]<='9')
                        sum+=1;
                }
                System.out.println(sum);
            }
        }
    }
}

