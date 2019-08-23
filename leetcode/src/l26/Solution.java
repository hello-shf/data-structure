package l26;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/8/15 6:29
 * @Version V1.0
 **/
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if(nums[i-1] == nums[i]){
                for (int j = i; j<n - 1; j++){
                    nums[j] = nums[j+1];
                }
                n --;
                i--;
            }
        }
        return n;
    }
    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 2, 2, 3};
        Solution solution = new Solution();
        int size = solution.removeDuplicates1(arr);
        System.out.println(size);
    }
}
