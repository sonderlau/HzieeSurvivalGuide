package HDOJ.week9;

import java.util.Scanner;

public class d1562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            boolean is = true;
            int tm=a;
            while(a<1000){
                a=a+tm;
            }

            //注意！答案的范围是[1000,9999]
            for (int i = a; i < 10000; i = i + tm) {
                //此处注意i是加tm，而不是再加a了，因为a可能变了。
                if ((i+1)%b==0&&(i+2)%c==0) {
                    System.out.println(i);
                    is = false;
                    break;
                }
            }

            if (is) {
                System.out.println("Impossible");
            }

        }
    }
}
