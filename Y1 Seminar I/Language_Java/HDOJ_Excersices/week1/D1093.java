package HDOJ.week1;

        import java.util.Scanner;

public class D1093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Rounds = sc.nextInt();
        for (int R = 0;R<Rounds;R++){
            int rounds = sc.nextInt();
            int sum=0;
            for (int r=0;r<rounds;r++){
                int temp = sc.nextInt();
                sum += temp;
            }
            System.out.println(sum);

        }
        sc.close();
    }
}
