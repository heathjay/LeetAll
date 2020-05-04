/**
 * 	给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	/**
	 * 全局变量+递归调用，
	 * 同一位点
	 */
	Map<String,String> map = new HashMap<String,String>(){
		{
			put("2","abc");
			put("3","def");
			put("4","ghi");
			put("5","jkl");
			put("6","mno");
			put("7","pqrs");
			put("8","tuv");
			put("9","wxyz");
		}
	};
	
	List<String> res = new ArrayList();
	private void combine(String pre, String s) {
		if(s.length() == 0) {
			res.add(pre);
			return;
		}else {
			String dig = s.substring(0,1);
			String now = map.get(dig);
			for(int i = 0 ; i < now.length();i++) {
				String letter = now.substring(i,i+1);
				String next = pre + letter;
				combine(next,s.substring(1));
			}
		}
	}
	 public List<String> letterCombinations(String digits) {
		 if(digits.length() != 0) {
			 combine("",digits);
		 }
		 return res;
	    }
}
