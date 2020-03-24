package HDOJ.week9;

import java.util.Scanner;

public class d2027 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){                                /*   *.hasNext()可以连续输入多组测试数据  */
            int n=sc.nextInt();
            sc.nextLine();                                     /*   接受换行符 */
            for(int i=1;i<=n;i++){
                String str = sc.nextLine();
                char[] ch=str.toCharArray();                   /*  把String 型的str 转换成 Char型的数组  */
                print('a',count('a',ch));                     /*  调用在函数：在函数print里调用count函数  */
                print('e',count('e',ch));
                print('i',count('i',ch));
                print('o',count('o',ch));
                print('u',count('u',ch));
                if(i!=n){
                    System.out.println();                      /*  没两组输出数据中，加一个换行  */
                }
            }
        }
    }
    static void print(char str,int a){                     /*  输出函数print  */
        System.out.println(str+":"+a);
    }
    static int count(char str,char[] chs){                /*  计数器函数  */
        int n=0;
        for(int i=0;i<chs.length;i++){
            if(chs[i]==str){                           /*  遇到一个我需要的统计的字符，我就n++  */
                n++;
            }
        }
        return n;                                       /*  返回一个int就是统计的数量  */
    }
}
