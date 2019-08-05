package r501;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/22 9:53
 * @Version V1.0
 **/
public class BSTR<E extends Comparable> {
    private class Node{
        private E e;
        private Node left, right;
        public Node(E e){
            this.e = e;
            this.left = right;
        }
    }
    private Node root;
    private int size;
    public BSTR(){
        root = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void add(E e){
        root = add(root, e);
    }
    public Node add(Node node, E e){
        if(node == null){
            size ++;
            return new Node(e);
        }
        if(e.compareTo(node.e) <= 0){
            node.left = add(node.left, e);
        } else if(e.compareTo(node.e) >= 0){
            node.right = add(node.right, e);
        }
        return node;
    }
    public boolean contains(E e){
        return contains(root, e);
    }
    public boolean contains(Node node, E e){
        if(node == null){
            return false;
        } else if(e.compareTo(node.e) == 0){
            return true;
        } else if(e.compareTo(node.e) < 0){
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }
/*---------------------------------深度优先遍历----------------------------------*/
    /**
     * 前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * 前序遍历 - 递归算法
     * @param node 开始遍历的根节点
     */
    public void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 前序遍历 - 非递归实现
     */
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    /**
     * 二分搜索树的中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * 中序遍历 - 递归
     * @param node
     */
    public void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * 后续遍历 - 递归
     * @param node
     */
    public void postOrder(Node  node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }
/*---------------------------------广度优先遍历--------------------------------*/

    /**
     * 层序优先遍历
     */
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            System.out.println(node.e);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }
/*--------------------------------------最值操作---------------------------------*/

    /**
     * 搜索二分搜索树中的最小值
     * @return
     */
    public E minimum(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).e;
    }

    /**
     * 搜索二分搜索树中以 node 为根节点的最小值所在的节点
     * @param node
     * @return
     */
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 搜索二分搜索树中的最大值
     * @return
     */
    public E maximum(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    /**
     * 搜索二分搜索树中以 node 为根节点的最大值所在的节点
     * @param node
     * @return
     */
    private Node maximum(Node node){
        if(node.right == null){
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 删除二分搜索树中的最小值
     * @return
     */
    public E removeMin(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        E e = minimum();
        root = removeMin(root);
        return e;
    }

    /**
     * TODO 没看懂
     * 删除二分搜索树中以 node 为根节点的最小节点
     * @param node
     * @return 删除后新的二分搜索树的跟
     */
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

    public E removeMax(){
        E e = maximum();
        root = removeMax(root);
        return e;
    }

    /**
     * 删除二分搜索树中以 node 为根节点的最小节点
     * @param node
     * @return
     */
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }
}
/*public void add(E e){
        if(root == null){
            root = new Node(e);
            size ++;
        }
        add(root, e);
    }
    public void add(Node node, E e){
        if(e.equals(node.e)){
            return;
        }else if(e.compareTo(node.e) < 0 && node.left == null){
            node.left = new Node(e);
            size ++;
            return;
        }else if(e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size ++;
            return;
        }
        if(e.compareTo(node.e) < 0){
            add(node.left, e);
        }else {
            add(node.right, e);
        }
    }*/