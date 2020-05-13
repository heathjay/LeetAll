/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。

示例：

输入: S = "ADOBECODEBANC", T = "ABC"
输出: "BANC"
说明：

如果 S 中不存这样的子串，则返回空字符串 ""。
如果 S 中存在这样的子串，我们保证它是唯一的答案。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-window-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode76;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	/**
	 * 移动窗口
	 * map做比较
	 * Map--更新
	 * ans存l，r，length
	 * @param s
	 * @param t
	 * @return
	 */
    public String minWindow(String s, String t) {
    	if(s.length() == 0|| t.length() == 0) {
    		return "";
    	}
    	
    	Map<Character,Integer> T = new HashMap<>();
    	for(int i = 0;i < t.length();i++) {
    		T.put(t.charAt(i), T.getOrDefault(t.charAt(i), 0) + 1);
    	}
    	
    	int Tsize = T.size();
    	
    	int l = 0 , r = 0;
    	int formed = 0;
    	Map<Character,Integer> window = new HashMap<>();
    	//window length, left,right
    	int[] ans = {-1,0,0};
    	
    	while(r < s.length()) {
    		char c = s.charAt(r);
    		window.put(c, window.getOrDefault(c, 0) + 1);
    		
    		if(T.containsKey(c) && window.get(c).intValue() == T.get(c).intValue()) {
    			formed++;
    		}
    		
    		while(l<=r && formed == Tsize) {
    			c = s.charAt(l);
    			if(ans[0] == -1 || r-l+1 < ans[0]) {
    				ans[0]=r-l+1;
    				ans[1]=l;
    				ans[2] = r;
    			}
    			window.put(c, window.get(c) -1);
    			if(T.containsKey(c) && window.get(c).intValue() < T.get(c).intValue()) {
    				formed--;
    			}
    			l++;
    			//更新window
    		}
    		r++;
    	}
    	return ans[0] == -1? "" :s.substring(ans[1],ans[2]+1);
    }
}
