package HDOJ.week10;

import java.util.Scanner;

public class d2031 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            boolean flag=false;
            if(n<0){
                flag=true;
                n=-n;
            }
            int arr[]=new int[50];
            int k=0;

            while(n>0){
                arr[k++]=n%m ;
                n=n/m;
            }
            int num=50;
            for(int i=49;i>=0;i--){
                if(arr[i]==0){
                    num--;
                }else{
                    break;
                }
            }

            if(flag){
                System.out.print("-");
            }
            for(int i=num-1;i>=0;i--){
                print(arr[i]);
            }
            System.out.println();
        }
    }
    public static void  print(int x){
        if(x>9){
            switch(x){
                case 10:System.out.print("A");break;
                case 11:System.out.print("B");break;
                case 12:System.out.print("C");break;
                case 13:System.out.print("D");break;
                case 14:System.out.print("D");break;
                case 15:System.out.print("F");break;
            }
        }else{
            System.out.print(x);
        }
    }
}
