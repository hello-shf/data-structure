package stack;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/18 14:36
 * @Version V1.0
 **/
public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
