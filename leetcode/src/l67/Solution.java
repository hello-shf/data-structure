package l67;

import java.util.Stack;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/9/8 13:18
 * @Version V1.0
 **/
public class Solution {
    public static String addBinary1(String a, String b) {
        String max, min;
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int c = a.length() - b.length();
        if(c < 0){
            max = b;
            min = a;
        }else{
            max = a;
            min = b;
        }
        c = Math.abs(c);
        int tmp = 0;
        for (int i=max.length() - 1; i>= 0; i--){
            int minInt = 0;
            if((i - c) >= 0 && (i - c) < min.length()){
                minInt = Integer.valueOf(String.valueOf(min.charAt(i - c)));
            }
            int cur = Integer.valueOf(String.valueOf(max.charAt(i))) + minInt + tmp;
            stack.add(String.valueOf(cur % 2));
            if((cur / 2) > 0){
                tmp = 1;
            }else {
                tmp = 0;
            }
        }
        if(tmp == 1){
            stack.push(String.valueOf(tmp));
        }
        while (!stack.isEmpty()){
            builder.append(stack.pop());
        }
        return builder.toString();
    }
    public static String addBinary(String a, String b) {
        if(a == null || b == null){
            return null;
        }
        StringBuilder builder = new StringBuilder();
        int tmp = 0;
        int r = 1;
        while(a.length() - r >= 0 || b.length() - r >= 0){
            int aa = 0, bb = 0;
            if(a.length() - r >= 0){
                aa = a.charAt(a.length() - r) - '0';
            }
            if(b.length() - r >= 0){
                bb = b.charAt(b.length() - r) - '0';
            }
            int sum = tmp + aa + bb;
            builder.append(sum % 2);
            tmp = sum / 2;
            r ++;
        }
        if(tmp == 1){
            builder.append(tmp);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11", b = "1";
        String s = addBinary(a, b);
        System.out.println(s);
//        String bb = "12345";
//        System.out.println(bb.charAt(0));
    }
}
/**
 67. 二进制求和
 思路：
 1，这个题的难点在于如何循环，因为不等长
 2，将两个数组的长度做减运算，while循环，判断只要两个的长度有一个没有减到0，则继续循环。
 3，while循环体内，超出长度的使用 0 补充，最后用StringBuilder拼接字符串
 */