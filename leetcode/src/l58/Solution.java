package l58;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/9/6 10:42
 * @Version V1.0
 **/
class Solution {
    public static int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        if(s1.length == 0){
            return 0;
        }
        return s1[s1.length-1].length();
    }

    public static void main(String[] args) {
        String s = " ";
        int i = lengthOfLastWord(s);
        System.out.println(i);
    }
}
