package recursion;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/17 11:33
 * @Version V1.0
 **/
public class Sum {
    public static int sum(int i){
        if(i == 1){
            return 1;
        }
        return i + sum(i - 1);
    }

    public static void main(String[] args) {
        System.out.println(sum(3));
    }
}
