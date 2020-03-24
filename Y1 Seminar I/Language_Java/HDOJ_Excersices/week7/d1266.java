package HDOJ.week7;

import java.util.Scanner;

public class d1266 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str = sc.next();
            int instr = Integer.parseInt(str);

            str = Integer.toString(instr);

            if (str.charAt(0) == '-') {
                System.out.print("-");
                int k = 0;
                boolean isOne=false;

                for (int i = str.length() - 1; i >= 1; i--) {

                    if(str.charAt(i)!='0'&&!isOne){

                        isOne=true;
                    }
                    if (isOne) {
                        System.out.print(str.charAt(i));
                        k++;
                    }
                }
                for (int i = 1; i < str.length() - k; i++) {
                    System.out.print(0);
                }
                System.out.println();
            } else {
                int k = 0;
                boolean isOne=false;
                for (int i = str.length() - 1; i >= 0; i--) {
                    if(str.charAt(i)!='0'&&!isOne){
                        isOne=true;
                    }
                    if (isOne) {
                        System.out.print(str.charAt(i));
                        k++;
                    }
                }
                for (int i = 0; i < str.length() - k; i++) {
                    System.out.print(0);
                }
                System.out.println();
            }
        }
    }
}
