package HDOJ.week7;

import java.util.Scanner;

public class D1201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            String str = sc.next();
            String[] num = str.split("-");
            int[] number = new int[3];
            for(int i=0;i<num.length;i++){
                number[i] = Integer.parseInt(num[i]);
            }
            int day=0;
            if(isRun(number[0])&&number[1]==2&&number[2]==29&&!isRun(number[0]+18)){
                System.out.println(-1);
                continue;
            }//出生的时候是闰年，2月29生，且18岁时候不是闰年，无生日。
            // TODO : ?????????
            if(number[1]<3){
                for(int i=0;i<18;i++){
                    if(isRun(number[0]+i)){
                        day+=366;
                    }else{
                        day+=365;
                    }
                }
            }else{
                for(int i=1;i<=18;i++){
                    if(isRun(number[0]+i)){
                        day+=366;
                    }else{
                        day+=365;
                    }
                }
            }


            System.out.println(day);


        }


    }

    private static boolean isRun(int i) {
        if((i%4==0&&i%100!=0)||(i%400==0)){
            return true;
        }
        return false;
    }
}

