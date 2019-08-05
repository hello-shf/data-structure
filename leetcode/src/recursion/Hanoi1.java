package recursion;

import java.util.Stack;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/17 17:32
 * @Version V1.0
 **/
public class Hanoi1 {
    private static Stack<Integer> stackA = new Stack<>();
    private static Stack<Integer> stackB = new Stack<>();
    private static Stack<Integer> stackC = new Stack<>();

    private static int total = 0;
    private static int countP = 3;
    public static void main(String[] args) {

        char A = 'A', B = 'B', C = 'C';
        push(stackA);
        hanoi(countP, stackA, stackB, stackC, A, B, C);
        print(stackC);
    }
    private static void hanoi(int n, Stack A, Stack B, Stack C, char a, char b, char c){
        if(n>0){
            System.out.println(String.valueOf(a)+String.valueOf(b)+String.valueOf(c) + "===n===" + n);
            hanoi(n-1, A, C, B, a, c, b);
            move(n, A, C, a, c);
            hanoi(n-1, B, A, C, b, a, c);
        }
    }
    private static void move(int n, Stack from, Stack to, char f, char t){
        System.out.println("第--" + (++total) + "--次移动第" + n + "个盘子：" + f + "-->" + t + "===n===" + n);
        to.push(from.pop());
    }
    private static Stack<Integer> push(Stack stack){
        for (int i=countP; i> 0; i--){
            stack.push(i);
        }
        return stack;
    }
    private static void print(Stack<Integer> stack){
        StringBuilder stringBuilder = new StringBuilder();
        while (stack.iterator().hasNext()){
            stringBuilder.append(stack.pop());
        }
        System.out.println(stringBuilder);
    }
}
