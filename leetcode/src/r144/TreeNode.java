package r144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 描述：leetcode 144 二叉树的前序遍历  145 二叉树的后序遍历
 *
 * @Author shf
 * @Date 2019/7/24 10:13
 * @Version V1.0
 **/

public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {
    List<Integer> list = new ArrayList<>();

    /**
     * 前序遍历递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }

    /**
     * 前序遍历非递归
     * @param root
     * @return
     */
    public List<Integer> preOrderNR(TreeNode root){
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if(cur.right != null)// right在前，栈的后进先出
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
        return list;
    }

    /**
     * 后序遍历 - 递归
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null)
            return list;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    public List<Integer> postOrderNR(TreeNode root) {
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> cache = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            cache.push(cur);
            if(cur.right != null) {
                postOrderNR(cur.right);
            }
            if(cur.left != null) {
                postOrderNR(cur.left);
            }
        }
        while(!cache.isEmpty()){
            list.add(cache.pop().val);
        }
        return list;
    }
}
