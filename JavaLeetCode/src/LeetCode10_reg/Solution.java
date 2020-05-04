/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
示例 3:

输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false


 */
package LeetCode10_reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jay
 *
 */
public class Solution {
	/**
	 * - p 为空？ s空否
	 * 
	 * - p 不为空
	 * 	- 首位：匹配 且 s不为空
	 * 	- 后一位是否*
	 * 		- 未匹配 || 首位非空且匹配，p不动，s吃掉首位
	 * 		- 首位匹配且不为空 && 全部后移
	 * @param s
	 * @param p
	 * @return
	 */
	 public static boolean isMatch(String s, String p) {
		 if(p.isEmpty())return s.isEmpty();
		 boolean first= (!s.isEmpty()&&((p.charAt(0) == s.charAt(0) )|| p.charAt(0) == '.' ));
		 
		 if(p.length() >=2 && p.charAt(1) == '*') {
			 return (isMatch(s,p.substring(2)) ||(first && isMatch(s.substring(1),p)));
		 }else {
			 return first && isMatch(s.substring(1),p.substring(1));
		 }
	  }

	 
	public static void main(String[] args) {
		String s = "1";
		Pattern p = Pattern.compile(".*");
		Matcher m = p.matcher(s);
		
		System.out.println(m.find());
	}

}
