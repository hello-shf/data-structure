package r168;

/**
 * 描述：leetCode 168
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 *
 * @Author shf
 * @Date 2019/8/8 18:06
 * @Version V1.0
 **/
public class Solution {
    public String combin(int n){
        if(n <= 0){
            throw new IllegalArgumentException("参数错误");
        }
        if(n <= 26 && n > 0){
            return String.valueOf ((char)((n-1) + 'A'));
        }
        int k = n%26;
        if(k == 0){
            k = 26;
            n -= 26;
        }
        return combin(n/26) + ((char)((k-1) + 'A'));
    }
    public String convertToTitle1(int n) {
        StringBuffer sb = new StringBuffer();

        while(n>0){
            int k=n%26;
            if(k==0){
                n-=26;
                k=26;
            }

            char c = (char)((k-1) +(int)'A');
            sb.insert(0,c);
            n = n/26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("1    ===>  " + solution.combin(1));
        System.out.println("26   ===>  " + solution.combin(26));
        System.out.println("51   ===>  " + solution.combin(51));
        System.out.println("52   ===>  " + solution.combin(52));
        System.out.println("53   ===>  " + solution.combin(53));
        System.out.println("256  ===>  " + solution.combin(256));
        System.out.println("703  ===>  " + solution.combin(703));

        System.out.println("---------------------");

        System.out.println("1    ===>  " + solution.convertToTitle1(1));
        System.out.println("26   ===>  " + solution.convertToTitle1(26));
        System.out.println("51   ===>  " + solution.convertToTitle1(51));
        System.out.println("52   ===>  " + solution.convertToTitle1(52));
        System.out.println("53   ===>  " + solution.convertToTitle1(53));
        System.out.println("256  ===>  " + solution.convertToTitle1(256));
        System.out.println("703  ===>  " + solution.convertToTitle1(703));
    }
}
