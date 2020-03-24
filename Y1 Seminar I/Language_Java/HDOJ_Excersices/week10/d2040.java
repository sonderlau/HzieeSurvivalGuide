package HDOJ.week10;

        import java.util.Scanner;

public class d2040 {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int m=sc.nextInt();
        while(m-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            if(a==YueSu(b)&&b==YueSu(a)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    public static int YueSu(int a){
        int sum=0;
        for(int i=1;i<=a/2;i++){
            if(a%i==0){
                sum=sum+i;
            }
        }
        return sum;
    }
}
