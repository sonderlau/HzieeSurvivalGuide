package HDOJ.week10;

import java.util.Scanner;

public class d2071 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        while(n>0){
            int m = in.nextInt();
            double[] highest = new double[m];
            int i,j;
            for(i=0;i<m;i++)
                highest[i]=in.nextDouble();

            double max=highest[0];
            for(i=0;i<m;i++)
                if(highest[i]>max)
                    max=highest[i];
            System.out.println(String.format("%.2f", max));
            n--;
        }
    }
}
