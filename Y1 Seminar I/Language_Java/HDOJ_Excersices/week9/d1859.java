package HDOJ.week9;

import java.util.Scanner;

public class d1859 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        while(sc.hasNext()){
            int minx = sc.nextInt();
            int maxx = minx;
            int miny =sc.nextInt();
            int maxy = miny;
            if(minx==0&&miny==0){
                break ;
            }

            while(true){
                int x = sc.nextInt();
                int y = sc.nextInt();
                if(x==0&&y==0){
                    break;
                }
                if(x>maxx){
                    maxx=x;
                }

                if(x<minx){
                    minx =x;
                }

                if(y>maxy){
                    maxy = y;
                }

                if(y<miny){
                    miny=y;
                }
            }

            System.out.println(minx+" "+miny+" "+maxx+" "+maxy);
        }
    }
}
