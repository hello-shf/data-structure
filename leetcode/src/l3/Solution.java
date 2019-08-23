package l3;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：leetcode - 3, 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *
 * @Author shf
 * @Date 2019/8/9 6:52
 * @Version V1.0
 **/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< s.length(); i++){
            if(map.put(s.charAt(i), i + 1) != null){
                count = Math.max(map.get(s.charAt(i)), count);
            }
            maxLen = Math.max(maxLen, i - count + 1);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        int maxLen = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                count = Math.max(map.get(s.charAt(i)), count);
            }
            maxLen = Math.max(maxLen, i - count + 1);
            map.put(s.charAt(i), i + 1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int l =  solution.lengthOfLongestSubstring2("pwwkew");
        System.out.println(l);
    }
}
