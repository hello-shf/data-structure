package recursion;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/17 15:56
 * @Version V1.0
 **/
public class Inverter {
    public static void main(String[] args) {
        int a = 5432;
        int b = invert(a);
        System.out.println(b);
    }
    public static int invert(int i){
        System.out.println(i%10);
        if(i < 10){
            return i;
        } else {
            return invert(i/10);
        }
    }
}
