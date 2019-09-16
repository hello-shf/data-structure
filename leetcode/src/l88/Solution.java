package l88;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/9/13 20:32
 * @Version V1.0
 **/
public class Solution {
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            for (int i=0; i < n; i++){
                nums1[i] = nums2[i];
            }
        }
        int len = m + n - 1;
        for (int i=m - 1; i >= 0; i--){
            for (int j=n-1; j >= 0; j--){
                if(nums1[i] > nums2[j]){
                    nums1[len] = nums1[i];
                    nums1[i] = 0;
                    len --;
                    break;
                }else{
                    nums1[len] = nums2[j];
                    nums2[j] = 0;
                    n --;
                    len --;
                }
            }
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        while (n > 0){
            if(m > 0 && n > 0 && nums1[m - 1] > nums2[n - 1]){
                nums1[len] = nums1[m - 1];
                m --;
            }else {
                nums1[len] = nums2[n - 1];
                n --;
            }
            len --;
        }
    }

    public static void main(String[] args) {
        int[] aa = {2, 0};
        int[] bb = {1};
        merge(aa, 1, bb, 1);
        System.out.println("-------------");
        for (int a : aa)
            System.out.println(a);
    }
}
