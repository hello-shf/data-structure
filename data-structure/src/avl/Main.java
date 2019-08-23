package avl;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/31 14:31
 * @Version V1.0
 **/
public class Main {
    public static void main(String[] args) {
        AVL<Integer, Integer> avl = new AVL<>();
        for (int i=0; i< 10; i++){
            avl.add(i, i);
        }
        System.out.println(avl.isBST());
        System.out.println(avl.isBalanced());
        avl.remove(5);
        System.out.println(avl.isBST());
        System.out.println(avl.isBalanced());
    }
}
