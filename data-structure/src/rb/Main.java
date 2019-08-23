package rb;


import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

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
        for (int i=1; i<6 ; i++){
            rb.add(i, i);
        }
        rb.remove(5);
        rb.levelOrder();

        TreeMap<String, String> map = new TreeMap<>();
    }
}
