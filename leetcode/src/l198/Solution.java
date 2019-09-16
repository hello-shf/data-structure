package l198;

import javax.lang.model.util.ElementScanner6;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/9/11 16:06
 * @Version V1.0
 **/
public class Solution {
    public static int rob(int[] nums) {
        int prev = 0, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = cur;
            cur = Math.max(prev + nums[i], cur);
            prev = temp;
        }
        return cur;
    }
    public static int rob1(int[] nums) {
        int prev = 0;
        int cur = 0;
        for(int x : nums){
            int temp = cur;
            cur = Math.max(prev + x, cur);
            prev = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] aa = {2, 7, 9, 3, 1};
        int rob = rob(aa);
        System.out.println(rob);
    }
}
/**
 #198. 打家劫舍
 示例 1:

 输入: [1,2,3,1]
 输出: 4
 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
      偷窃到的最高金额 = 1 + 3 = 4 。

 思路：等同于 max = math.max(f(i - 2) + f(i), f(i - 1)),
    1,难点：如何让数组循环起来是这个很大的问题
    假如数组长度为1，这时我们需要将数组补偿，及将数组当成是len + 2使数组循环起来






 */
