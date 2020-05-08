/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。

'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。
两个字符串完全匹配才算匹配成功。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "*"
输出: true
解释: '*' 可以匹配任意字符串。
示例 3:

输入:
s = "cb"
p = "?a"
输出: false
解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
示例 4:

输入:
s = "adceb"
p = "*a*b"
输出: true
解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
示例 5:

输入:
s = "acdcb"
p = "a*c?b"
输入: false

 */
package LeetCode44;

public class Solution {
	/**
	 * 双指针
	 * - 用jstart去控制移动
	 * - istart 去测试0或1 匹配
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		if(p==null||p.isEmpty()) return s==null || s.isEmpty();
		int i = 0, j = 0, jstart = -1, istart = -1, slen = s.length(), plen =p.length();
		
		while(i<slen) {
			if(j<plen && (s.charAt(i) == p.charAt(j)|| p.charAt(j) == '?')) {
				i++;
				j++;
			}
			
			else if(j<plen && p.charAt(j) == '*') {
				istart = i;
				jstart = j++;
			}else if(istart > -1) {
				i = ++istart;
				j=jstart+1;
			}else {
				return false;
			}
		}
		
		while(j<plen && p.charAt(j) =='*')j++;
		return j == plen;
		
	}
	/**
	 * 动态规划
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch1(String s, String p) {
		if(p==null||p.isEmpty()) return s==null||s.isEmpty();
		int slen = s.length(), plen = p.length();
		boolean[][] dp = new boolean[slen+1][plen+1];
		
		dp[0][0] = true;
		//只有j位置和其前面全为*才为true
		for(int j = 1; j <= plen;j++) dp[0][j] = p.charAt(j-1)=='*' && dp[0][j-1];
		for(int i = 1; i <= slen;i++) {
			for(int j = 1; j <= plen;j++) {
				char si = s.charAt(i-1);
				char pj = p.charAt(j-1);
				if(si == pj||pj =='?') {
					dp[i][j] = dp[i-1][j-1];
				}else if(pj == '*') {
					dp[i][j] = dp[i-1][j]||dp[i][j-1];
				}
			}
		}
		return dp[slen][plen];
	}
	
	
}

