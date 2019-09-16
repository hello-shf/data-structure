package sort;


/**
 * 描述：快速排序
 *
 * @Author shf
 * @Date 2019/9/7 16:05
 * @Version V1.0
 **/
public class QuickSort {
    public static void quickSort(int[] arr, int low, int height){
        if(low < height){
            int middleIndex = getMiddleIndex(arr, low, height);
            quickSort(arr, low, middleIndex - 1);
            quickSort(arr, middleIndex + 1, arr.length - 1);
        }
    }
    public static int getMiddleIndex(int[] arr, int low, int height){
        int base = arr[low];
        while (low < height){
            while (low < height && base <= arr[height]){
                height --;
            }
            arr[low] = arr[height];

            while(low < height && base >= arr[low]){
                low ++;
            }
            arr[height] = arr[low];
        }
        arr[low] = base;
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 3, 2, 5 ,7 ,1};
        quickSort(arr, 0, arr.length - 1);
        for(int a : arr){
            System.out.println(a);
        }
    }
}
