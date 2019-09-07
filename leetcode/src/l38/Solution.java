package l38;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/8/23 16:54
 * @Version V1.0
 **/
class Solution {
    public static String countAndSay(int n) {
        if(n < 1 || n > 30){
            return null;
        }
        if(n == 1){
            return "1";
        }
        String str = countAndSay(n - 1);
        String newStr = "";
        int l = 1;
        for (int i=1; i< str.length(); i++){
            if(str.charAt(i - 1) == str.charAt(i)){
                l ++;
            }else {
                newStr += l + String.valueOf(str.charAt(i - 1));
                l = 1;
            }
        }
        newStr += l + String.valueOf(str.charAt(str.length() - 1));
        return newStr;
    }
    public static String countAndSay1(int n) {
        if(n < 1 || n > 30){
            return null;
        }
        if(n == 1){
            return "1";
        }
        String str = countAndSay1(n - 1);
        String newStr = "";
        int l = 1;
        for (int i=1; i< str.length(); i++){
            if(str.charAt(i - 1) == str.charAt(i)){
                l ++;
            }else {
                newStr += l + String.valueOf(str.charAt(i - 1));
                l = 1;
            }
        }
        newStr += l + String.valueOf(str.charAt(str.length() - 1));
        return newStr;
    }

    public static void main(String[] args) {
        String s = Solution.countAndSay(5);
        System.out.println(s);
    }
}

/**
 #38 报数
 思路：
    1，反递归
    2，计算递归返回的上一层递归的字符串，就开始简单的循环，没增加一个相同的，则对计数器 ++。否则置为 1.然后拼接字符串


 */
