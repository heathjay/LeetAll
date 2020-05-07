/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

 

示例：

输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {
	 public List<String> generateParenthesis(int n) {
		 List<String> combination = new ArrayList<String>();
		 generate(new char[2 * n], 0, combination);
		 return combination;
	    }
	 
	 public void generate(char[] current, int pos, List<String> result) {
		 if(pos == current.length) {
			 if(isValid(current)) {
				 result.add(new String(current));
			 }
		 }else {
			 current[pos] = '(';
			 generate(current,pos+1,result);
			 current[pos] = ')';
			 generate(current,pos+1,result);
		 }
	 }
	 public boolean isValid(char[] current) {
		 int balance = 0;
		 for(char c : current) {
			 if(c == '(') balance++;
			 else balance -- ;
			 if(balance < 0 ) return false;
		 }
		 return balance == 0;
	 }
}
