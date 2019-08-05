package recursion;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/17 22:49
 * @Version V1.0
 **/
public class Combine {
    private static AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) {
        String[] strs = {"a", "b", "c"};
        combine(strs, 0, strs.length);
    }
    public static void combine(String[] ss, int begin, int end){
        if(begin == end -1 ){
            for(int i = 0; i< end; i++){
                System.out.print(ss[i]);
            }
            System.out.println();
        } else {
            for(int i = begin; i< end; i++){
                System.out.println("----执行交换----");
                swap(ss, begin, i);
                combine(ss, begin+1, end);
                System.out.println("----执行复原----");
                swap(ss, begin, i);
            }
        }
    }
    public static void swap(String[] ss, int begin, int end){
        count.getAndAdd(1);
        System.out.println("当前数组：" + arrToStrng(ss) + "==交换的元素为：" + ss[begin] + "与" + ss[end]);
        String tmp = ss[end];
        ss[end] = ss[begin];
        ss[begin] = tmp;
    }
    public static String arrToStrng(String[] ss){
        String aa = "";
        for (String s : ss){
            aa += s;
        }
        return aa;
    }
}
