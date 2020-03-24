package HDOJ.week7;

import java.util.Scanner;

public class d1234 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            int num = sc.nextInt();
            sc.nextLine();

            String id = sc.next();
            String openDoor = id;
            String closeDoor = id;
            String comeTime = sc.next();
            String leftTime = sc.next();
            for (int i = 2; i <= num ; i++) {
                String tempId = sc.next();
                String tempComeTime = sc.next();
                String tempLeftTime = sc.next();
                if (tempComeTime.compareTo(comeTime) < 0){
                    openDoor = tempId;
                    comeTime = tempComeTime;
                }
                if (tempLeftTime.compareTo(leftTime) > 0){
                    closeDoor = tempId;
                    leftTime = tempLeftTime;
                }
            }
            System.out.println(openDoor + " " + closeDoor);

        }

    }
}
