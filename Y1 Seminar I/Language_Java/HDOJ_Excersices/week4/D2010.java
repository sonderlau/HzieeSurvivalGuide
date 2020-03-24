package HDOJ.week4;

        import java.util.Scanner;

public class D2010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            String result = "";
            for (int i = a; i <= b; i++) {
                if (judgeNumber(i)){

                    result += i + " ";
                }
            }
            result = result.trim();

            if ("".equals(result)){
                result = "no";
            }
            System.out.println(result);
        }
        sc.close();
    }

    public static boolean judgeNumber(int num) {
        int hundredNum = num / 100;
        int tenNum = num /10 % 10;
        int geNum = num % 10;
        return ((Math.pow(hundredNum,3) + Math.pow(tenNum,3) + Math.pow(geNum,3)) == num);
    }
}
