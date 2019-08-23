package l27;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/8/21 16:47
 * @Version V1.0
 **/
public class Solution {
    public static int removeElement(int[] nums, int val) {
        int l = nums.length;
        for(int i=0; i< l; i++){
            if(nums[i] == val){
                nums[i] = nums[l - 1];
                i --;
                l --;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,2,3};
        int i = removeElement(arr, 3);
        System.out.println(i);
    }
}
/**
 #27. 数组中移除元素，不能创建新的数组
 思路：
 1，发现相等的就和最后面的元素进行交换
 2，每次交换后更新数组长度 即 l --；
 坑：每次交换后需要重新验证当前索引位置的元素，即 i --；
 */