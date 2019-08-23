package l9;

import java.util.LinkedList;

/**
 * 描述：leetcode 9 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * @Author shf
 * @Date 2019/8/11 19:02
 * @Version V1.0
 **/
public class Solution {
    // 队列
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x < 10 && x > -10){
            return true;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        while(x != 0){
            queue.add(x%10);
            x = x/10;
        }
        while (queue.size() != 1 && queue.size() != 0){
            if(queue.removeFirst() != queue.removeLast()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isPalindrome(121));
    }
}
