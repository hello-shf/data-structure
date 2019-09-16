package l70;

import sun.awt.image.IntegerInterleavedRaster;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/9/10 21:04
 * @Version V1.0
 **/
public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    private int climbStairs(int n, int cur){
        if (cur > n) {
            return 0;
        }
        if (cur == n) {
            return 1;
        }
        return climbStairs(n, cur + 1) + climbStairs(n, cur + 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        for(int i=1; i< 6; i++){
            System.out.println(solution.climbStairs(44));
//        }
    }
}
