package sort;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/9/7 21:59
 * @Version V1.0
 **/
public class HeapSort {
    public static void heapSort(int[] arr){
        int len = arr.length;
        for(int i = (len / 2) - 1; i >= 0; i--){
            heapify(arr, i, len);
        }
        for(int i = len; i > 0; i--){
            swap(arr, 0, len - 1);
            len --;
            heapify(arr, 0, len);
        }
    }
    public static void heapify(int[] arr, int cur, int len){
        while (cur * 2 + 1 < len){
            int l = cur * 2 + 1;
            if(l + 1 < len && arr[l] < arr[l + 1]){
                 l ++;
            }
            if(arr[cur] >= arr[l]){
                break;
            }
            swap(arr, cur, l);
            cur = l;
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 3, 2, 5 ,7 ,1};
        heapSort(arr);
        for(int a : arr){
            System.out.println(a);
        }
    }

}
