package recursion;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/17 14:23
 * @Version V1.0
 **/
public class MergeArray {
    public static void main(String[] args) {
        int[] a = {1, 7, 8};
        int[] b = {2, 4, 6, 9};
        int[] c = merge(a, b);
        for (int i : c) {
            System.out.println(i);
        }
    }

    public static int[] merge(int[] a, int[] b) {
        int[] newArr = new int[a.length + b.length];
        int i=0, j=0, k=0;
        while (i < a.length && j < b.length){
            if(a[i] <= b[j]){
                newArr[k++] = a[i++];
            } else {
                newArr[k++] = b[j++];
            }
        }
        while (i < a.length){
            newArr[k++] = a[i++];
        }
        while (j < b.length){
            newArr[k++] = b[j++];
        }
        return newArr;
    }
}
