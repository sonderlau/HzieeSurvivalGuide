package HDOJ.week9;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class d2014 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int cnt = 0;
            int[] arr = new int[n];
            while((n--)>0){
                arr[cnt++] = scanner.nextInt();
            }
            Arrays.sort(arr);
            int sum = 0;
            for(int i=0;i<arr.length;i++){
                sum += arr[i];
            }
            double ans;
            ans = (sum - arr[0] - arr[arr.length-1])/((arr.length-2)*1.00);
            DecimalFormat df = new DecimalFormat("#0.00");
            System.out.println(df.format(ans));
        }
    }
}
