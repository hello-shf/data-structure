package array;

import java.util.Stack;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/18 11:45
 * @Version V1.0
 **/
public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        for(int i = 0 ; i < 10 ; i ++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        for(int i = 0 ; i < 4 ; i ++){
            arr.removeFirst();
            System.out.println(arr);
        }

        Stack stack = new Stack();
    }
}
