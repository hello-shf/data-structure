package l121;

import java.util.jar.JarEntry;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/9/11 15:09
 * @Version V1.0
 **/
public class Solution {
    /**
     * 暴力法
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int max = 0;
        for(int i=0; i< prices.length - 1; i++){
            for (int j = i + 1; j< prices.length; j++){
                if(prices[j] - prices[i] > max){
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    /**
     * 动态规划法
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices){
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i=0; i< prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else if(prices[i] - min > max){
                max = prices[i] -min;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] aa = {7,6,4,3,1};
        int i = maxProfit(aa);
        System.out.println(i);
        int[] bb = {7,1,5,3,6,4};
        int j = maxProfit(bb);
        System.out.println(j);
    }
}
/**
 刷动态规划 #121. 买卖股票的最佳时机
 1，暴力法没什么好说的，循环两遍，时间复杂度O(n^2)
 2，动态规划思路：
    （1）缓存一个最小值，初始化最小值设为Integer.max。缓存一个最大值（即返回值）
    （2）首先判断当前值cur是不是最小的，如果是最小的，替换缓存的最小值min，
        如果大于最小值，判断 cur-min > max，如果大于max，则更新max。
    （3）最重要的一个思路是找到最小值后面的最大值，该最小值不一定是整个数组中最小的，
        但是我们可以通过后面的判断保证当前最小值和当前值之间的差值是最大的
  */
