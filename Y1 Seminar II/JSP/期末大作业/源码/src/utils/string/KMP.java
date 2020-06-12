package utils.string;

public class KMP {

    /**
     * @param string 
     * @param next
     * @param length
     */
    public static void calculate_next(String string, int[] next, int length) {
        next[0] = -1;//next[0]初始化为-1，-1表示不存在相同的最大前缀和最大后缀
        int k = -1;//k初始化为-1
        for (int q = 1; q <= length - 1; q++) {
            while (k > -1 && string.charAt(k + 1) != string.charAt(q))//如果下一个不同，那么k就变成next[k]，注意next[k]是小于k的，无论k取任何值。
            {
                k = next[k];//往前回溯
            }
            if (string.charAt(k + 1) == string.charAt(q))//如果相同，k++
            {
                k = k + 1;
            }
            next[q] = k;//这个是把算的k的值（就是相同的最大前缀和最大后缀长）赋给next[q]
        }

    }

    /**
     * @param source_string 源字符串
     * @param target_string 需要查找的字符串
     * @return 返回找到的位置
     */
    public static int KMPMain(String source_string, String target_string) {

        int source_length = source_string.length();
        int target_length = target_string.length();

        int[] next = new int[target_length];

        //
        calculate_next(target_string, next, target_length);//计算next数组
        int k = -1;
        for (int i = 0; i < source_length; i++) {
            while (k > -1 && target_string.charAt(k + 1) != source_string.charAt(i))//ptr和str不匹配，且k>-1（表示ptr和str有部分匹配）
                k = next[k];//往前回溯
            if (target_string.charAt(k + 1) == source_string.charAt(i))
                k = k + 1;
            if (k == target_length - 1)//说明k移动到ptr的最末端
            {

                return i - target_length + 1;//返回相应的位置
            }
        }
        return -1;
    }
}
