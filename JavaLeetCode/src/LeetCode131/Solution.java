/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例:

输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-partitioning
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode131;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
    	int len = s.length();
    	List<List<String>> res = new ArrayList<>();
    	if(len == 0) return res;
    	
    	Deque<String> stack = new ArrayDeque<>();
    	backtrack(s, 0 , len, stack, res);
    	return res;
    }
    public void backtrack(String s, int start, int len, Deque<String> path, List<List<String>> res) {
    	if(start == len) {
    		res.add(new ArrayList<>(path));
    		return;
    	}
    	for(int i = start; i < len; i++) {
    		if(!checkPalindrome(s,start,i)) continue;
    		path.addLast(s.substring(start, i + 1));
    		backtrack(s, i + 1, len, path, res);
    		path.removeLast();
    	}
    }
    private boolean checkPalindrome(String str, int left, int right) {
    	while(left < right) {
    		if(str.charAt(left) != str.charAt(right)) {
    			return false;
    		}
    		left++;
    		right--;
    	}
    	return true;
    }
}
