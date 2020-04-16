package No1;

public class NJA {



    public static void main(String[] args) {

        int[] variables = new int[4];
        System.out.println("P\tQ\tR\tS\tA");
        createTruthTables(variables);

    }

    private static void createTruthTables (int[] variables) {
        int rows = (int) Math.pow(2,4);

        for (int i = 0 ; i < rows ; i ++){
            for (int j = 3; j >= 0 ; j --){
                variables[j] = i/(int) Math.pow(2, j)%2 ;
            }
            printTruthTables(variables);
        }
    }

    private static void printTruthTables (int[] variables) {
        // 处理 表达式
        // A=﹁( p 或 q ) 与 ( (p 或 r) 与 s)

        int result = WITH( NOT(OR(variables[0],variables[1])),WITH(OR(variables[0],variables[2]),variables[3]) );

        System.out.println(variables[0] + "\t" + variables[1] + "\t" + variables[2] + "\t" + variables[3] + "\t" + result);


    }



    // 或
    private static int OR (int a, int b){
        if (a == 0 && b == 0){
            return 0;
        } else {
            return 1;
        }
    }

    // 与
    private  static int WITH (int a, int b){
        if (a == 1 && b == 1){
            return 1;
        } else {
            return 0;
        }
    }


    // 非
    private static int NOT (int a){
        return a == 0 ? 1 : 0 ;
    }






}
