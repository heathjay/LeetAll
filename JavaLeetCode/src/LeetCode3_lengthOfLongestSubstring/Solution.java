package LeetCode3_lengthOfLongestSubstring;
import java.util.ArrayList;
/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
输入:
"dvdf"
输出
2
预期结果
3



 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public static int lengthOfLongestSubstring(String s) {
		int pre = 0;
		int count = 0;
		int start=0;
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		
		for(char temp : s.toCharArray()) {
			if(map.containsKey(temp)) {
				if(start <= map.get(temp)) {
					start = map.get(temp)+1;
				}
			}
			pre = Math.max(count-start+1, pre);
			map.put(temp, count++);
		}
		return pre;
    }
	
	public static void main(String[] args) {
		String str = "dvdf";
		String str2 = "a";
		String str3 = "pwwkew";
		System.out.println(lengthOfLongestSubstring(str));
		System.out.println(lengthOfLongestSubstring(str2));
		System.out.println(lengthOfLongestSubstring(str3));
	}
}
