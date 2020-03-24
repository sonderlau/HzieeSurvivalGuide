package HDOJ.week8;

import java.util.Scanner;

public class d1408 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        while(sc.hasNext()){
            double v = sc.nextDouble();
            double d = sc.nextDouble();

            int t=1;
            int tm=0;
            while(true){
                boolean is=false;
                for(int i=0;i<t;i++){
                    v=v-d;
                    tm++;
                    if(v<0.000001){
                        is=true;
                        break;
                    }
                }

                if(is){
                    break;
                }
                t++;
                tm++;
            }
            System.out.println(tm);
        }
    }
}
