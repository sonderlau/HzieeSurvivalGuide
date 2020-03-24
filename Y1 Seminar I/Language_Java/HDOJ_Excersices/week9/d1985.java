package HDOJ.week9;

import java.util.Scanner;

public class d1985 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = {"kg","l","lb","g"};
        String[] str2 = {"lb","g","kg","l"};
        double[]  d = {2.2046,0.2642,0.4536,3.7854};
        int time = 1;
        int t = sc.nextInt();
        while(t-->0){
            int k=0;
            double n = sc.nextDouble();
            String s = sc.next();
            for(int i=0;i<str1.length;i++){
                if(s.equals(str1[i])){
                    k=i;
                    n = n*d[i];
                    break;
                }
            }
            System.out.printf("%d %.4f %s",time,n,str2[k] );
            System.out.println();
            time++;
        }


    }
}
