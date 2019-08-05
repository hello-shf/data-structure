package recursion;

import java.math.BigInteger;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/17 15:34
 * @Version V1.0
 **/
public class Multiplication {
    public static void main(String[] args) {
//        System.out.println(10*2);
        System.out.println(mul(10));
    }
    public static BigInteger mul(int i){
        if(i == 1){
            return BigInteger.ONE;
        } else {
            return BigInteger.valueOf(i).multiply(mul(i-1));
        }
    }
}
