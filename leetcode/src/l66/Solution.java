package l66;

/**
 * 描述: leetcode 66 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @Author shf
 * @Date 2019/9/7 15:14
 * @Version V1.0
 **/
public class Solution {
    public static int[] plusOne(int[] digits) {
        if(digits.length == 0){
            return null;
        }
        for(int i=digits.length - 1; i>=0; i--){
            if(digits[i] == 9){
                digits[i] = 0;
            }else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        int[] newDigits = new int[digits.length +1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        int[] aa = {1,9,9};
        int[] bb = plusOne(aa);
        for (int b : bb) {
            System.out.println(b);
        }
    }
}
/**
 首先是用数组表示的非负整数，所示需要考虑何时扩容的问题。
 如果刚开始就创建一个新数组（长度为原数组长度+1）这样空间复杂度就不是很好。
 我们可以想，需要数组扩容的情况一定是该整数每一位上都是9。
 所以，我们就通过循环判断遇9将当前位置为1.否则给当前位执行+1操作。
 如果代码能运行到循坏外说明，需要扩容，这时只需要创建一个原数组长度+1的新数组。
 利用int的初始值为0的特性，所以只需要将索引为0位置的数字置为1即可。
 */