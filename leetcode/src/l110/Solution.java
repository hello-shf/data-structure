package l110;


/**
 * 描述：leetcode 110 判断二叉树是否是平衡二叉树
 *
 * @Author shf
 * @Date 2019/7/31 16:47
 * @Version V1.0
 **/
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int balanceFactor = getBalanceFactor(root);
        if(Math.abs(balanceFactor) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int getLeftHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        return getLeftHeight(node.left) + 1;
    }
    public int getRightHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        return getRightHeight(node.right) + 1;
    }
    public int getBalanceFactor(TreeNode node){
        if(node == null){
            return 0;
        }
        return getLeftHeight(node.left) - getRightHeight(node.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.add(1);
        node.add(6);
        node.add(5);
        node.add(7);
        Solution solution = new Solution();
        boolean boo = solution.isBalanced(node);
        System.out.println(boo);
    }
}
class Solution1{
    boolean ret;
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return ret;
    }
    public int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        int l = getHeight(node.left) + 1;
        int r = getHeight(node.right) + 1;
        if(Math.abs(l-r) > 1){
            ret = false;
        }
        return Math.max(l, r);
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.add(1);
        node.add(6);
        node.add(5);
        node.add(7);
        Solution solution = new Solution();
        boolean boo = solution.isBalanced(node);
        System.out.println(boo);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){

    }
    TreeNode(int x) {
        val = x;
        this.left = null;
        this.right = null;
    }
    public void add(int val){
        add(this, val);
    }
    public TreeNode add(TreeNode node, int val){
        if(node == null){
            return new TreeNode(val);
        }
        if(val > node.val){
            node.right = add(node.right, val);
        }else{
            node.left = add(node.left, val);
        }
        return node;
    }
}
