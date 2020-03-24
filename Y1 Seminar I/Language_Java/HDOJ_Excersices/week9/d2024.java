package HDOJ.week9;

import java.util.Scanner;

public class d2024 {
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        String s;
        int n=cin.nextInt();
        cin.nextLine();
        for(int i=0;i<n;i++){
            s=cin.nextLine();
            if(s.charAt(0)=='_'||s.charAt(0)>='a'&&s.charAt(0)<='z'||s.charAt(0)>='A'&&s.charAt(0)<='Z')    {
                int t=1;
                for(int j=1;j<s.length();j++){
                    if(s.charAt(j)=='_'||s.charAt(j)>='a'&&s.charAt(j)<='z'||s.charAt(j)>='A'&&s.charAt(j)<='Z'||s.charAt(j)>='0'&&s.charAt(j)<='9')
                        t=t+1;
                }
                if(t==s.length())
                    System.out.println("yes");
                else
                    System.out.println("no");
            }
            else
                System.out.println("no");
        }
    }
}
