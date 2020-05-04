package LeetCode14;
/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。



 * @author jay
 *
 */
public class Solution {
	/**
	 * - 假设第一个字符串就是最长公共字串
	 * - 与后一个比更新最长字串
	 * @param strs
	 * @return
	 */
	 public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) return "";
		String pre = strs[0];
		for(int i = 0 ; i < strs.length;i++) {
			while(strs[i].indexOf(pre) != 0) {
				pre = pre.substring(0, pre.length() - 1);
				if(pre.isEmpty()) return "";
			}
		}
		return pre;
	  }
	public static void main(String[] args) {

	}

}
