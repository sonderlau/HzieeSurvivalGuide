package utils.string;

public class StringModification {
    /**
     * @description 用来向字符串的前后增加单引号
     * @param string 待处理的字符串
     * @return 处理好的单引号
     */
    public static String AddSingleQuotation(String string) {
        return "'" + string +"'";
    }

    /**
     * @description 将字符串前后的双引号删除
     * @param str 待处理字符串
     * @return 处理好的字符串
     */
    public static String TrimDoubleDots(String str) {

        if(str.indexOf("\"")==0) {
            str = str.substring(1);
        }
        if(str.lastIndexOf("\"")==(str.length()-1)) {
            str = str.substring(0,str.length()-1);
        }
        return str;
    }
}
