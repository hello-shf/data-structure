package l7;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/8/10 12:23
 * @Version V1.0
 **/
public class Solution {
    public static int reverse(int x) {
        long y = 0;
        while(x != 0){
            y = y*10 + x%10;
            x = x/10;
        }
        if(y > Integer.MAX_VALUE || y < Integer.MIN_VALUE){
            return 0;
        }
        return (int) y;
    }


    public static void main(String[] args) {
        int a = reverse(321);
        System.out.println(a);
        System.out.println(Math.abs(-10));
        System.out.println(Math.abs(10));

        int b = (int) Math.pow(2, 31) - 1;
        System.out.println(b);
        System.out.println(1534236469);
    }
}
