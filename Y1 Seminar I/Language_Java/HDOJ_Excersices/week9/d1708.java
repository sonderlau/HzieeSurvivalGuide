package HDOJ.week9;

import java.util.Scanner;

public class d1708 {
    public static void main(String[] args) {
        long num[][] = new long[56][26];
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            for(int i=0;i<num[0].length;i++){
                for(int j=0;j<num.length;j++){
                    num[j][i]=0;
                }
            }
            String str0 = sc.next();
            for(int i=0;i<str0.length();i++){
                for(int j='a';j<='z';j++){
                    if(str0.charAt(i)==(char)j){
                        num[0][j-'a']++;
                        break;
                    }
                }
            }
            String str1 = sc.next();
            for(int i=0;i<str1.length();i++){
                for(int j='a';j<='z';j++){
                    if(str1.charAt(i)==(char)j){
                        num[1][j-'a']++;
                        break;
                    }
                }
            }
            int n = sc.nextInt();
            for(int i=2;i<=n;i++){
                for(int k='a';k<='z';k++){
                    num[i][k-'a'] = num[i-1][k-'a']+num[i-2][k-'a'];
                }
            }

            for(int k='a';k<='z';k++){
                System.out.println((char)k+":"+num[n][k-'a']);
            }
            System.out.println();

        }
    }
}
