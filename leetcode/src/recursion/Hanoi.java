package recursion;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/17 16:56
 * @Version V1.0
 **/
public class Hanoi {
    static int total = 0;
    public static void main(String[] args) {
        int n = 64;
        hanoi(n, 'A', 'B', 'C');
        int totalCount = 2;
        while(n>1){
            totalCount *= 2;
            n--;
        }
        System.out.println("移动次数：" + (totalCount-1));
    }
    private static void hanoi(int n, char A, char B, char C){
        if(n>0){
            hanoi(n-1, A, C, B);
            print(n, A, C);
            hanoi(n-1, B, A, C);
        }
    }
    private static void print(int n, char from, char target){
//        System.out.println("第--" + (++total) + "--次移动第" + n + "个盘子：" + from + "-->" + target);
    }
}
