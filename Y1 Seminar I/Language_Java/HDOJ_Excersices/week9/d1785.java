package HDOJ.week9;

import java.util.Scanner;

public class d1785 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if (n<0) {
                break;
            }
            double point[][] = new double[n][3];
            for (int i = 0; i < n; i++) {
                point[i][0]=sc.nextDouble();
                point[i][1]=sc.nextDouble();
                point[i][2] = Math.atan2(point[i][1],point[i][0]);
            }
            for (int i = 0; i < point.length-1; i++) {
                for (int j = i+1; j < point.length; j++) {
                    if (point[i][2]>point[j][2]) {
                        double temp = point[i][0];
                        point[i][0] = point[j][0];
                        point[j][0] = temp;
                        temp = point[i][1];
                        point[i][1] = point[j][1];
                        point[j][1] = temp;
                        temp = point[i][2];
                        point[i][2] = point[j][2];
                        point[j][2] = temp;
                    }
                }
            }
            System.out.printf("%.1f %.1f",point[0][0],point[0][1]);
            for (int i = 1; i < point.length; i++) {
                System.out.printf(" %.1f %.1f",point[i][0],point[i][1]);
            }
            System.out.println();
        }
        sc.close();
    }
}
