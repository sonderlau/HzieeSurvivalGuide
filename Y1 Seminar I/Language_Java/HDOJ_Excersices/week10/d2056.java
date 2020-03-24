package HDOJ.week10;

import java.util.Scanner;

public class d2056 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            double[] x = new double[4];
            double[] y = new double[4];
            for(int i=0;i<x.length;i++){
                x[i] = sc.nextDouble();
                y[i] = sc.nextDouble();
            }
            if(x[1]<x[0]){
                double temp=x[0];
                x[0]=x[1];
                x[1]=temp;
            }
            if(y[1]<y[0]){
                double temp=y[0];
                y[0]=y[1];
                y[1]=temp;
            }
            if(x[3]<x[2]){
                double temp=x[3];
                x[3]=x[2];
                x[2]=temp;
            }
            if(y[3]<y[2]){
                double temp=y[3];
                y[3]=y[2];
                y[2]=temp;
            }
            double x1 = max(x[0],x[2]);
            double y1 = max(y[0],y[2]);
            double x2 = min(x[1],x[3]);
            double y2 = min(y[1],y[3]);
            if(x1>x2||y1>y2){
                System.out.println("0.00");
                continue;
            }else{
                System.out.printf("%.2f",(x2-x1)*(y2-y1));
                System.out.println();
            }
        }
    }
    private static double min(double d, double e) {
        if(d<e){
            return d;
        }
        return e;
    }
    private static double max(double d, double e) {
        if(d>e){
            return d;
        }
        return e;
    }
}
