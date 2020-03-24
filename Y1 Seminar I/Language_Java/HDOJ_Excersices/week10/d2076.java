package HDOJ.week10;

import java.util.Scanner;

public class d2076 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int h = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
            if(h>=12){
                h-=12;
            }
            double mm = (m+s/60.0)/60.0*360.0;
            double hh = (h+m/60.0+s/60.0/60.0)/12.0*360.0;
            double min,max;
            min = mm>hh?hh:mm;
            max = mm>hh?mm:hh;
            if(max-min>180){
                System.out.println((int)(360-(max-min)));
            }else{
                System.out.println((int)(max-min));
            }
        }
    }

}
