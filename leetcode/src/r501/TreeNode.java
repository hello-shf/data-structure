package r501;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述：leetcode 501 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 *
 * @Author shf
 * @Date 2019/7/24 18:16
 * @Version V1.0
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){}
    TreeNode(int x) { val = x; }
    /**
     * 添加数据
     * @param val
     */
    public void add(int val) {
        add(this, val);
    }
    public TreeNode add(TreeNode node, int val){
        if(node == null){
            return new TreeNode(val);
        }
        //将等于的情况优先放到为空的孩子节点上，否则按照 左孩子-右孩子 的顺序插入
        if(val == node.val && node.left == null)
            node.left = add(node.left, val);
        else if(val == node.val && node.right == null)
            node.right = add(node.right, val);
        else if(val < node.val)
            node.left = add(node.left, val);
        else if(val > node.val)
            node.right = add(node.right, val);
        return node;
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(this);
    }
    public void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }
}


class Solution {
    List<Integer> list = new ArrayList<>();
    Integer maxCount = 0;
    Integer curCount = 0;
    TreeNode pre = null;

    public int[] findMode(TreeNode root) {
        find(root);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    /**
     * 利用中序遍历的 有序性
     * @param root
     */
    public void find(TreeNode root) {
        if (root == null) {
            return;
        }
        find(root.left);
        // pre.val == root.val 需要将 curCount ++
        if(pre != null && pre.val == root.val){
            curCount ++;
        } else {// pre == null 和pre.val != root.val的情况，curCount都需要重新初始化
            curCount = 0;
        }
        if(curCount == maxCount){// 如果相等 list 新增当前节点的值
            list.add(root.val);
        } else if(curCount > maxCount){// 如果大于 清空list，并且将当前节点值添加到list，并维护maxCount
            list.clear();
            list.add(root.val);
            maxCount = curCount;
        }
        pre = root;
        find(root.right);
    }

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(1);
        bst.add(2);
        /*bst.add(2);
        bst.add(3);
        bst.add(6);
        bst.add(5);
        bst.add(8);
        bst.add(9);
        bst.add(4);
        bst.add(4);*/
        System.out.println("-------------中序遍历------------");
        bst.inOrder();
        Solution solution = new Solution();
        int[] arr = solution.findMode(bst);
        System.out.println("-------------众数结果------------");
        for(int i = 0; i<arr.length; i++)
            System.out.println(arr[i]);
    }
}

/**
 * 在网上找的solution
 * 对于测试用例：[1,2,2,3,6,5,8,9,4,4] 验证写的TreeNode是否正确。放到 leetcode 输出结果错误。
 */
class Solution1{
    private int count = -1;
    private int lastVal = Integer.MAX_VALUE;
    private int maxCount = 0;

    private List<Integer> list = new LinkedList<Integer>();

    public int[] findMode(TreeNode root) {
        find(root);
        //check last part
        if (count > maxCount) {
            list.clear();
            list.add(lastVal);
        } else if (count == maxCount) {
            list.add(lastVal);
        }

        int[] results = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            results[i] = list.get(i);
        }
        return results;

    }

    private void find(TreeNode root) {
        if (root == null) {
            return;
        }
        find(root.left);
        if (root.val != lastVal) {
            if (count > maxCount) {
                maxCount = count;
                list.clear();
                list.add(lastVal);
            } else if (count == maxCount) {
                list.add(lastVal);
            }
            count = 1;
            lastVal = root.val;
        } else {
            count++;
        }
        find(root.right);
    }
    public static void main(String[] args) {
        TreeNode bst = new TreeNode(1);
        bst.add(2);
        bst.add(2);
        bst.add(3);
        bst.add(6);
        bst.add(5);
        bst.add(8);
        bst.add(9);
        bst.add(4);
        bst.add(4);
        System.out.println("-------------中序遍历------------");
        bst.inOrder();
        Solution1 solution = new Solution1();
        int[] arr = solution.findMode(bst);
        System.out.println("-------------众数结果------------");
        for(int i = 0; i<arr.length; i++)
            System.out.println(arr[i]);
    }
}

class Solution3 {
    ArrayList<Integer>res = null;
    TreeNode pre = null;
    int max = 0;
    int cns = 1;
    public int[] findMode(TreeNode root) {
        //存放结果
        res = new ArrayList<Integer>();
        middle_search(root);
        int[] arr =new int[res.size()];
        for(int i =0; i < arr.length; i++)
            arr[i] = res.get(i);
        return arr;
    }
    public void middle_search(TreeNode root) {
        if(root == null)
            return ;
        middle_search(root.left);
        //处理根结点
        if(pre != null){  //有父节点
            if(root.val == pre.val)
                cns++;
            else cns = 1;
        }
        if(cns >= max){
            if(cns > max)
                res.clear();
            max = cns;
            res.add(root.val);
        }
        pre = root;

        middle_search(root.right);
    }
}
