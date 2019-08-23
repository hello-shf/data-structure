package l199;

import org.omg.CosNaming.IstringHelper;

import java.util.*;

/**
 * 描述：199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 *
 * @Author shf
 * @Date 2019/8/16 6:28
 * @Version V1.0
 **/
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
        int max_depth = -1;

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        queue.add(root);
        depthQueue.add(0);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            int depth = depthQueue.remove();

            if (node != null) {
                max_depth = Math.max(max_depth, depth);

                rightmostValueAtDepth.put(depth, node.val);

                queue.add(node.left);
                queue.add(node.right);
                depthQueue.add(depth+1);
                depthQueue.add(depth+1);
            }
        }

        List<Integer> rightView = new ArrayList<>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        right1(root, list);
        return list;
    }
    public void right1(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.right == null){
            right1(root.left, list);
        } else {
            right1(root.right, list);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.add(3);
        root.add(6);
        root.add(2);

        Solution solution = new Solution();
        List<Integer> list = solution.rightSideView(root);
        System.out.println();
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
