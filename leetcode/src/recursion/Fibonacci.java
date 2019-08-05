package recursion;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/17 14:03
 * @Version V1.0
 **/
public class Fibonacci {
    public static void main(String[] args) {
        int total = 8;
        for(int i = 1; i< total; i++){
            System.out.println("---月份：" + i + "---兔子数：" + fun(i));
        }
    }
    public static int fun(int i){
        if(i == 1 || i == 2){
            return 1;
        } else {
            return fun(i -1) + fun(i - 2);
        }
    }
}
