package r94;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：leetcode 94 二叉树的中序遍历
 *
 * @Author shf
 * @Date 2019/7/24 16:25
 * @Version V1.0
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution{
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return list;
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
}
