package rb;


/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/8/1 14:13
 * @Version V1.0
 **/
public class Main {
    public static void main(String[] args) {
        RBTree<Integer, Integer> rb = new RBTree<>();
        for (int i=0; i< 2; i++){
            rb.add(i, i);
        }
        rb.levelOrder();
    }
}
