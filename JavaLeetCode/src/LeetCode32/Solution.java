/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode32;

import java.util.Stack;

public class Solution {
	public static int longestValidParentheses1(String s) {
		int maxans=0;
		int dp[] = new int[s.length()];
		for(int i = 1; i < s.length();i++) {
			if(s.charAt(i) == ')') {
				if(s.charAt(i-1) == '(') {
					dp[i] = ((i >= 2) ? dp[i-2] :0) +2;
				}else if(i - dp[i-1] > 0 && s.charAt(i-dp[i-1] -1) =='(') {
					dp[i] = dp[i-1] + ((i - dp[i-1]) >= 2 ? dp[i-dp[i-1] -2] : 0) + 2;
				}
				maxans = Math.max(maxans, dp[i]);
			}
		}
		return maxans;
	
    }
	public static int longestValidParentheses(String s) {
		int maxans = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for(int i = 0; i < s.length(); i ++) {
			if(s.charAt(i) == '(') {
				stack.push(i);
			}else {
				stack.pop();
				if(stack.empty()) {
					stack.push(i);
				}else {
					maxans = Math.max(maxans, i - stack.peek());
				}
			}
		}
		return maxans;
	}
	
	 public static void main(String[] args) {
		 System.out.println(longestValidParentheses1(")()())"));
	 }
}
