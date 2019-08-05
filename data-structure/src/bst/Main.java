package bst;

import java.util.Random;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/22 10:12
 * @Version V1.0
 **/
public class Main {
    public static void main(String[] args) {
//        test();
        order();
    }
    public static void order(){
        BST<Integer> bst = new BST<>();

        int rang = 20;
        Random random = new Random();
        for(int i=0; i< 15; i++){
            int value = random.nextInt(rang);
            System.out.println(value);
            bst.add(value);
            if(bst.size() == 8){
                break;
            }
        }
        System.out.println("-------------前序遍历------------");
        bst.preOrder();

        System.out.println("-------------中序遍历------------");
        bst.inOrder();

        System.out.println("-------------后序遍历------------");
        bst.postOrder();

    }
    public static void test(){
        BST<Integer> bst = new BST<>();
        bst.add(5);
        bst.add(4);
        bst.add(7);
        bst.add(6);
        bst.add(2);
        bst.add(3);
        bst.add(8);
        bst.add(1);
//        System.out.println(bst);
        System.out.println(bst.contains(8));
        System.out.println("-------------前序遍历------------");
        bst.preOrder();
        System.out.println("-------------前序遍历非递归-------------");
        bst.preOrderNR();
        System.out.println("-------------中序遍历------------");
        bst.inOrder();
        System.out.println("-------------中序遍历非递归-------------");
        bst.inOrderNR();
        System.out.println("-------------后序遍历------------");
        bst.postOrder();
        System.out.println("-------------后序遍历非递归-------------");
        bst.postOrderNR();
        System.out.println("-------------层序遍历------------");
        bst.levelOrder();
        System.out.println("-------------最小值------------");
        System.out.println(bst.minimum());
        System.out.println("-------------最大值------------");
        System.out.println(bst.maximum());
        System.out.println("-------------删除最小值-------------");
        System.out.println(bst.removeMin());
        System.out.println("-------------前序遍历------------");
        bst.preOrder();
        System.out.println("-------------删除最大值-------------");
        System.out.println(bst.removeMax());
        System.out.println("-------------前序遍历------------");
        bst.preOrder();
    }
}
