package l102;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：102. 二叉树的层次遍历
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @Author shf
 * @Date 2019/9/16 9:30
 * @Version V1.0
 **/
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrder(root, 0, list);
        return list;
    }
    public void levelOrder(TreeNode root, int level, List<List<Integer>> list){
        if(root == null){
            return;
        }
        if(list.size() == level){
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        levelOrder(root.left, (level + 1), list);
        levelOrder(root.right, (level + 1), list);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
/**
 深度遍历，记录递归深度，递归深度 = 二叉树的高度。然后将list的index对应递归深度
 */