package HDOJ.week10;

import java.util.Scanner;

public class d2034 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            if(n==0&&m==0){
                break;	//n，m同时为0时停止运行
            }
            int a[]=new int[n];	//集合A
            int b[]=new int[m];	//集合B
            int c[]=new int[n];	//集合C
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            for(int i=0;i<m;i++){
                b[i]=sc.nextInt();
            }
            int count=0;	//标记集合A是否全部属于集合B
            int count1=0;	//记录集合A中有多少个数不属于集合B
            for(int i=0;i<n;i++){
                boolean t=false;	//标记集合b中是否有与a[i]相等的数
                for(int j=0;j<m;j++){
                    if(a[i]==b[j]){
                        t=true;
                    }
                }
                if(t){		//如果有count标记++；
                    count++;
                }else{		//否则则这个数是集合B中没有的
                    c[count1]=a[i];	//把这个数放到集合C中
                    count1++;
                }
            }
            if(count==n){	//如果标记等于n，说明集合A中所有的数属于集合B
                System.out.print("NULL");
            }else{
                for(int i=0;i<count1;i++){	//把集合C排序
                    for(int j=i+1;j<count1;j++){
                        if(c[i]>c[j]){
                            int t=c[i];
                            c[i]=c[j];
                            c[j]=t;
                        }
                    }
                }
                for(int i=0;i<count1;i++){
                    System.out.print(c[i]+" ");
                }
            }
            System.out.println();
        }
    }
}
