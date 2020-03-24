package HDOJ.week7;

import java.util.Scanner;

public class D1236 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int studentNum = sc.nextInt();
            if (studentNum == 0){
                return;
            }
            int practiceNum = sc.nextInt();
            int scoreStandard = sc.nextInt();
            int countScoreAchieved = 0;
            // 储存每道题目的分数
            int[] scoreEachPractice = new int[practiceNum+1];
            // 录入题目分数
            for (int i = 1; i <scoreEachPractice.length ; i++) {
                scoreEachPractice[i] = sc.nextInt();
            }
            // 读取考生信息
            // 考生准考证号 以及 分数
            String[] eachStudentId = new String[studentNum];
            int[][] eachStudentScore =  new int[studentNum][2];
            for (int i = 0; i < studentNum; i++) {
                // Id
                eachStudentId[i] = sc.next();
                // 做出的个数
                int solvedNum = sc.nextInt();

                // 解决题目的题号 直接转成分数
                for (int j = 0; j < solvedNum; j++) {
                    int solvedId = sc.nextInt();
                    eachStudentScore[i][0] += scoreEachPractice[solvedId];
                }
                // 是否达到线上
                if (eachStudentScore[i][0] >= scoreStandard){
                    // 向右复制一列
                    eachStudentScore[i][1] = eachStudentScore[i][0];
                    countScoreAchieved ++;
                }
            }
            // 上线个数
            System.out.println(countScoreAchieved);

            // 排序
            for (int i = 0; i < studentNum; i++) {
                for (int j = i+1; j < studentNum; j++) {
                    if (eachStudentScore[j][1] > eachStudentScore[i][1]){
                        // 交换

                        // 分数交换
                        int temp = eachStudentScore[i][1];
                        eachStudentScore[i][1] = eachStudentScore[j][1];
                        eachStudentScore[j][1] = temp;
                        // Id位置交换
                        String tempStr = eachStudentId[i];
                        eachStudentId[i] = eachStudentId[j];
                        eachStudentId[j] = tempStr;

                    }
                    // 分数相等
                    // 按照考生号升序输出
                    if (eachStudentScore[j][1] == (eachStudentScore[i][1]) && eachStudentId[i].compareTo(eachStudentId[j]) > 0){
                        // 交换

                        // 分数交换
                        int temp = eachStudentScore[i][1];
                        eachStudentScore[i][1] = eachStudentScore[j][1];
                        eachStudentScore[j][1] = temp;
                        // Id位置交换
                        String tempStr = eachStudentId[i];
                        eachStudentId[i] = eachStudentId[j];
                        eachStudentId[j] = tempStr;
                    }

                }
            }

            // 输出
            for (int i = 0; i < studentNum; i++) {
                // 除 0
                if (eachStudentScore[i][1] != 0){
                    System.out.println(eachStudentId[i] + " " + eachStudentScore[i][1]);
                }
            }


        }
    }



}