package HDOJ.week9;

import java.util.Scanner;

public class d1799 {
    static int db[][] = new int[2005][2005];
    public static void main(String[] args) {
        dabiao();
        Scanner sc = new Scanner(System.in);

        int t =sc.nextInt();
        while(t-->0){
            int m =sc.nextInt();
            int n = sc.nextInt();
            System.out.println(db[n][m]);
        }

    }
    private static void dabiao() {
        for(int i=1;i<=2000;i++){
            db[1][i]=0;
            db[i][1]=i%1007;
        }
        for(int i=2;i<=2000;i++){
            for(int j=2;j<=i;j++){
                db[i][j] = (db[i-1][j]+db[i-1][j-1])%1007;
            }
        }
    }
}
