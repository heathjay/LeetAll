/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回符合要求的最少分割次数。

示例:

输入: "aab"
输出: 1
解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode132;

public class Solution {
    public int minCut(String s) {
    	int len = s.length();
    	if(len < 2) return 0;
    	//状态定义dp[i] 前缀s[i] 符合要求最少分割次数
    	//转移 dp[i] = min
    	int[] dp = new int[len];
    	for(int i = 0; i < len;i++) dp[i] = i;
    	
    	boolean[][] checkPalindrome = new boolean[len][len];
    	for(int right = 0; right< len; right++) {
    		for(int left = 0 ; left <= right; left++) {
    			if(s.charAt(left) == s.charAt(right) && (right - left <= 2 || checkPalindrome[left+1][right-1])) {
    				checkPalindrome[left][right] = true;
    			}
    		}
    	}
    	for(int i = 1; i < len ; i++) {
    		if(checkPalindrome[0][i]) {
    			dp[i]=0;
    			continue;
    		}
    		for(int j = 0; j < i; j ++) {
    			if(checkPalindrome[j+1][i] ) {
    				dp[i] = Math.min(dp[i], dp[j] + 1);
    			}
    		}
    	}
    	return dp[len - 1];
    }
}
