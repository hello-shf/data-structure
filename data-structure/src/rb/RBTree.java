package rb;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/8/1 9:42
 * @Version V1.0
 **/
public class RBTree<K extends Comparable<K> , V>{
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public boolean color;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }
        @Override
        public String toString(){
            return "key-->" + key + "== value-->" + value + "== color-->" + color;
        }
    }
    private Node root;
    private int size;

    public RBTree(){
        root = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    private boolean isRed(Node node){
        if(node == null){
            return BLACK;
        }
        return node.color;
    }
    //   y                        x
    //  /  \     左旋转         /  \
    // T1   x   --------->     y   T3
    //     / \                /      \
    //    T2 T3              T1      T2
    private Node leftRotate(Node y){
        Node x = y.right;
        Node t2 = x.left;

        y.right = t2;
        x.left = y;

        x.color = y.color;
        y.color = RED;

        return x;
    }
    //     y                       x
    //    / \     右旋转         /  \
    //   x  T2   ------->       z    y
    //  / \                         /  \
    // z  T1                       T1  T2
    private Node rightRotate(Node y){
        Node x = y.left;
        Node t1 = x.right;

        y.left = t1;
        x.right = y;

        x.color = y.color;
        y.color = RED;

        return x;
    }
    private void flipColors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }
    public void add(K key, V value){
        root = add(root, key, value);
        root.color = BLACK;
    }
    private Node add(Node node, K key, V value){
        if(node == null){
            size ++;
            return new Node(key, value);
        }
        if(key.compareTo(node.key) < 0){
            node.left = add(node.left, key, value);
        } else if(key.compareTo(node.key) > 0){
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        if(isRed(node.right) && !isRed(node.left)){
            node = leftRotate(node);
        }
        if(isRed(node.left) && isRed(node.left.left)){
            node = rightRotate(node);
        }
        if(isRed(node.left) && isRed(node.right)){
            flipColors(node);
        }
        return node;
    }
    public void levelOrder(){
        levelOrder(root);
    }
    private void levelOrder(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur);
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }
}
