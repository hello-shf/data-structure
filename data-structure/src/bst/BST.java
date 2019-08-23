package bst;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 描述：二叉树的实现
 * 需要泛型是可比较的，也就是泛型必须实现 Comparable 接口
 *
 * @Author shf
 * @Date 2019/7/22 9:53
 * @Version V1.0
 **/
public class BST<E extends Comparable> {
    /**
     * 节点内部类
     */
    private class Node{
        private E e;
        private Node left, right;//左右孩子节点
        public Node(E e){
            this.e = e;
            this.left = right;
        }
    }

    /**
     * BST的根节点
     */
    private Node root;
    /**
     * 记录BST的 size
     */
    private int size;
    public BST(){
        root = null;
        size = 0;
    }

    /**
     * 对外提供的获取 size 的方法
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 二分搜索树是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 添加元素
     * @param e
     */
    public void add(E e){
        root = add(root, e);
    }

    /**
     * 添加元素 - 递归实现
     * 时间复杂度 O(log n)
     * @param node
     * @param e
     * @return 返回根节点
     */
    public Node add(Node node, E e){
        if(node == null){// 如果当前节点为空，则将要添加的节点放到当前节点处
            size ++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0){// 如果小于当前节点，递归左孩子
            node.left = add(node.left, e);
        } else if(e.compareTo(node.e) > 0){// 如果大于当前节点，递归右孩子
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 搜索二分搜索树中是否包含元素 e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root, e);
    }

    /**
     * 搜索二分搜索树中是否包含元素 e
     * 时间复杂度 O(log n)
     * @param node
     * @param e
     * @return
     */
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
     * 时间复杂度 O(n)
     * @param node 开始遍历的根节点
     */
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        // 不做复杂的操作，仅仅将遍历到的元素进行打印
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 前序遍历 - 非递归
     */
    public void preOrderNR(){
        preOrderNR(root);
    }

    /**
     * 前序遍历 - 非递归实现
     * 时间复杂度 O(n)
     */
    private void preOrderNR(Node node){
        Stack<Node> stack = new Stack<>();
        stack.push(node);
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
     * 时间复杂度 O(n)
     * @param node
     */
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 中序遍历 - 非递归
     */
    public void inOrderNR(){
        inOrderNR(root);
    }

    /**
     * 中序遍历 - 非递归实现
     * 时间复杂度 O(n)
     * @param node
     */
    private void inOrderNR(Node node){
        Stack<Node> stack = new Stack<>();
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.println(node.e);
            node = node.right;
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * 后续遍历 - 递归
     * 时间复杂度 O(n)
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

    /**
     * 后序遍历 - 非递归
     */
    public void postOrderNR(){
        postOrderNR(root);
    }

    /**
     * 后序遍历 - 非递归实现
     * 时间复杂度 O(n)
     * @param node
     */
    private void postOrderNR(Node node){
        Stack<Node> stack = new Stack<>();
        Stack<Node> out = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            out.push(cur);

            if(cur.left != null){
                stack.push(cur.left);
            }
            if(cur.right != null){
                stack.push(cur.right);
            }
        }
        while(!out.isEmpty()){
            System.out.println(out.pop().e);
        }
    }
/*---------------------------------广度优先遍历--------------------------------*/

    /**
     * 层序优先遍历
     * 时间复杂度 O(n)
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
     * 删除二分搜索树中以 node 为根节点的最小节点
     * @param node
     * @return 删除后新的二分搜索树的跟
     */
    //////////////////////////////////////////////////
    //             12                     12        //
    //           /     \                 /   \      //
    //          8       18   ----->     10    18    //
    //           \      /                     /     //
    //           10    15                    15     //
    //////////////////////////////////////////////////
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;// 将node.right（10） 赋值给 rightNode 保存
            node.right = null;// 将node的right与树断开连接
            size --;
            return rightNode; // rightNode(10)返回给递归的上一层，赋值给 12 元素的左节点。
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
    //////////////////////////////////////////////////
    //             12                      12       //
    //           /     \                 /    \     //
    //          8       18   ----->     8     15    //
    //           \      /                \          //
    //           10    15                 10        //
    //////////////////////////////////////////////////
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left; // 将node.right（15） 赋值给 leftNode 保存
            node.left = null;// 将 node 的 left 与树断开连接
            size --;
            return leftNode; // leftNode (10)返回给递归的上一层，赋值给 12 元素的右节点。
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为e的节点
     * @param e
     */
    public void remove(E e){
        root = remove(root, e);
    }

    /**
     * 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
     * @param node
     * @param e
     * @return 返回删除节点后新的二分搜索树的根
     */
    private Node remove(Node node, E e){

        if( node == null )
            return null;

        if( e.compareTo(node.e) < 0 ){
            node.left = remove(node.left , e);
            return node;
        } else if(e.compareTo(node.e) > 0 ){
            node.right = remove(node.right, e);
            return node;
        } else{   // e.compareTo(node.e) == 0 找到待删除的节点 node

            // 待删除节点左子树为空，直接将右孩子替代当前节点
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除节点右子树为空，直接将左孩子替代当前节点
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空
            // 找到右子树最小的元素，替代待删除节点
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
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