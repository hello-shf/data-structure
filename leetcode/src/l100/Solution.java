package l100;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/9/14 22:23
 * @Version V1.0
 **/
public class Solution {
    boolean isSame = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        preOrder(p, q);
        return isSame;
    }
    public void preOrder(TreeNode p, TreeNode q){
        if (p == null && q == null) {
            return;
        } else if ((p == null && q != null) || (p != null && q == null)) {
            isSame = false;
            return;
        }
        if(p.val != q.val){
            isSame = false;
        }
        preOrder(p.left, q.left);
        preOrder(p.right, q.right);
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }