package l35;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/8/22 20:58
 * @Version V1.0
 **/
public class Solution {
    public static int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        for(int i=0; i< nums.length; i++){
            if(target == nums[i] || target < nums[i]){
                return i;
            }
        }
        return nums.length;
    }
    public static int search(int[] nums, int target){
        int l = nums.length;
        if(nums[l - 1] < target){
            return l;
        }
        int left = 0;
        int right = l - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(target == nums[mid]){
                return mid;
            }else if (target > nums[mid]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 6, 7, 9};
        int i = searchInsert(arr, 10);
        System.out.println(i);
    }
}
/**
 #35. 搜索插入位置
 二分法
 因为是有序数组，采用二分法，将目标元素和中间的对比
 如果小于中间元素。移动左边界为mid。反之移动有边界
 */