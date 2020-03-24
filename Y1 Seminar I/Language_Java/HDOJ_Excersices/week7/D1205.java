package HDOJ.week7;

import java.util.Scanner;

public class D1205 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        //count组数据
        while(count-- > 0){
            int N = scan.nextInt();
            //单个组中糖果种类
            long sum = 0;
            //注意long注意long注意long!!!!!!!!!!!!!!!!!!!!
            int max = -1;
            for(int i=0;i<N;i++){
                int candy = scan.nextInt();
                sum += candy;
                if(max<candy)max = candy;
            }
            if((sum-max+1) >= max){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}

