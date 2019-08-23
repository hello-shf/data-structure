package rb;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述：红黑树的实现
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
    //////////////////////////////////////////
    //   y                        x         //
    //  /  \     左旋转         /  \        //
    // T1   x   --------->     y   T3       //
    //     / \                /      \      //
    //    T2 T3              T1      T2     //
    //////////////////////////////////////////
    private Node leftRotate(Node y){
        Node x = y.right;
        Node t2 = x.left;

        y.right = t2;
        x.left = y;

        x.color = y.color;// 为了向上兼容，将新的根节点变成老根节点的颜色
        y.color = RED; // 将被旋转的节点颜色置为红色。

        return x;
    }
    //////////////////////////////////////////
    //     y                       x        //
    //    / \     右旋转         /  \       //
    //   x  T2   ------->       z    y      //
    //  / \                         /  \    //
    // z  T1                       T1  T2   //
    //////////////////////////////////////////
    private Node rightRotate(Node y){
        Node x = y.left;
        Node t1 = x.right;

        y.left = t1;
        x.right = y;

        x.color = y.color;// 为了向上兼容，将新的根节点变成老根节点的颜色
        y.color = RED;// 将被旋转的节点颜色置为红色。

        return x;
    }

    /**
     * 颜色翻转
     * @param node
     */
    ////////////////////////////////////////
    //      黑                   红       //
    //     /  \     ------>     /  \      //
    //   红    红             黑    黑    //
    ////////////////////////////////////////
    private void flipColors(Node node){
        node.color = RED; // 置为红色，为了向上融合，在2-3树中，3节点分裂后的根节点要向上融合
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 添加元素
     * @param key
     * @param value
     */
    public void add(K key, V value){
        root = add(root, key, value);
        root.color = BLACK;
    }

    /**
     * 添加元素
     * @param node
     * @param key
     * @param value
     * @return
     */
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
        // 右孩子为红 左旋
        if(isRed(node.right) && !isRed(node.left)){
            node = leftRotate(node);
        }
        // 左孩子的左孩子为红 右旋
        if(isRed(node.left) && isRed(node.left.left)){
            node = rightRotate(node);
        }
        // 左右孩子都是红色 颜色翻转
        if(isRed(node.left) && isRed(node.right)){
            flipColors(node);
        }
        return node;
    }
    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key){

        if(node == null)
            return null;

        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }
    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除键为key的节点
    public V remove(K key){

        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key){

        if( node == null )
            return null;

        if( key.compareTo(node.key) < 0 ){
            node.left = remove(node.left , key);
            return node;
        }
        else if(key.compareTo(node.key) > 0 ){
            node.right = remove(node.right, key);
            return node;
        }
        else{   // key.compareTo(node.key) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
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
