package l69;


/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/9/9 18:10
 * @Version V1.0
 **/
public class Solution {
    public static final int mySqrt(int x) {
        long a = x;
        while(a * a > x){
            a = (a + x / a) / 2;
        }
        return (int) a;
    }

    public static void main(String[] args) {
        int i = mySqrt(4);
        System.out.println(i);
    }
}
