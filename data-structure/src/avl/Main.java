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
        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (int i=0; i< 10; i++){
            avl.add(i, i);
        }
        System.out.println(avl.isBST());
        System.out.println(avl.isBalance());
    }
}
