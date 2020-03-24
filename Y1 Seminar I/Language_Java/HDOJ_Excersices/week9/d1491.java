package HDOJ.week9;

import java.util.Scanner;

public class d1491 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a[]={31,28,31,30,31,30,31,31,30,31};
        int n=sc.nextInt();
        while(n-->0){
            int month=sc.nextInt();
            int day=sc.nextInt();
            if(month==10&&day==21){
                System.out.println("It's today!!");
            }
            else if(month>10||month==10&&day>21){
                System.out.println("What a pity, it has passed!");
            }
            else if(month==10&&day<21){
                System.out.println(21-day);
            }
            else{
                int sum=0;
                sum+=21;	//先加上10月份的天数
                for(int i=month-1;i<9;i++){//从这个月遍历到9月
                    if(i==month-1){
                        sum+=a[i]-day;	//当这个月是输入的月份时，总天数等于该月的总天数减去经过的天数
                    }else{
                        sum+=a[i];
                    }
                }
                System.out.println(sum);
            }
        }
    }
}
