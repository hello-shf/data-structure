package recursion;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/21 16:15
 * @Version V1.0
 **/
public class ArrSum {
    private static int sum1(int[] arr,  int index){
        if(index < 0){
            return 0;
        }
        return arr[index] + sum1(arr, (index - 1));
    }
    private static int sum2(int[] arr, int index){
        if(index == arr.length)
            return 0;
        return arr[index] + sum2(arr, (index + 1));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum1(arr, (arr.length-1)));

        System.out.println(sum2(arr, 0));
    }
}
