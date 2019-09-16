package l101;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/9/15 21:52
 * @Version V1.0
 **/
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }
    public boolean isSymmetric(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        return (node1.val == node2.val) && isSymmetric(node1.right, node2.left) && isSymmetric(node1.left, node2.right);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
