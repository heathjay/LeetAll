/**
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。

示例 1:

输入: "aacecaaa"
输出: "aaacecaaa"
示例 2:

输入: "abcd"
输出: "dcbabcd"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-palindrome
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode214;

public class Solution {
	/**
	 * 暴力
	 * @param s
	 * @return
	 */
	public boolean isPalindromic(String s, int start, int end) {
		char[] c = s.toCharArray();
		while(start < end) {
			if(c[start] != c[end]) return false;
			start++;
			end--;
		}
		return true;
	}
    public String shortestPalindrome(String s) {
    	int end = s.length() - 1;
    	for(; end >0; end--) {
    		if(isPalindromic(s,0,end)) break;
    	}
    	return new StringBuilder(s.substring(end+1)).reverse()+s;
    }
    /**
     * 
     * @param s
     * @return
     */
    public String shortestPalindrome1(String s) {
    	int i =0, j = s.length() - 1;
    	char[] c = s.toCharArray();
    	while(j>=0) {
    		if(c[i]==c[j]) {
    			i++;
    		}
    		j--;
    	}
    	if(i == s.length()) return s;
    	String sfx = s.substring(i);
    	String reverse = new StringBuilder(sfx).reverse().toString();
    	return reverse + shortestPalindrome(s.substring(0,i)) + sfx;
    }
    /**
     * 
     * @param s
     * @return
     */
    public String shortestPalindrome2(String s) {
    	String r = new StringBuilder(s).reverse().toString();
    	int n = s.length();
    	int i = 0;
    	for(; i < n;i++) {
    		if(s.substring(0,n-i).equals(r.substring(i)))break;
    	}
    	return new StringBuilder(s.substring(n-i)).reverse() + s;
    }
    /**
     * 
     * @param s
     * @return
     */
    public String shortestPalindrome3(String s) {
    	int n = s.length(),pos = -1;
    	int b = 26;
    	int pow = 1;
    	char[] c = s.toCharArray();
    	int hash1 = 0, hash2 = 0;
    	for(int i = 0; i < n ; i++, pow=pow*b) {
    		hash1 = hash1 * b + (c[i] - 'a' + 1);
    		hash2 = hash2 + (c[i] - 'a' + 1) * pow;
    		if(hash1 == hash2) pos = i;
    	}
    	return new StringBuilder(s.substring(pos+1)).reverse()+s;
    }
    /**
     * 
     * @param s
     * @return
     */
    public String shortestPalindrome4(String s) {
    	String ss = s +'#' + new StringBuilder(s).reverse();
    	int max = getLastNext(ss);
    	return new StringBuilder(s.substring(max)).reverse() + s;
    }
    public int getLastNext(String s) {
    	int n = s.length();
    	char[] c = s.toCharArray();
    	int[] next = new int[n+1];
    	next[0] = -1;
    	next[1] = 0;
    	int k =0;
    	int i = 2;
    	while(i <= n) {
    		if(k == -1 || c[i-1] == c[k]) {
    			next[i] = k+1;
    			k++;
    			i++;
    		}else {
    			k = next[k];
    		}
    	}
    	return next[k];
    }
    /**
     * 马拉车
     * @param s
     * @return
     */
    public String shortestPalindrome5(String s) {
    	String T = preProcess(s);
    	int n = T.length();
    	int[] P = new int[n];
    	int C = 0, R = 0;
    	for(int i = 1; i <n-1;i++) {
    		int i_mi = 2 * C - i;
    		if(R >i) {
    			P[i] = Math.min(R-i, P[i_mi]);
    		}else {
    			P[i] = 0;
    		}
    		while(T.charAt(i+1+P[i]) == T.charAt(i - 1 - P[i])) {
    			P[i]++;
    		}
    		if(i+P[i] > R) {
    			C = i;
    			R = i + P[i];
    		}
    	}
    	
    	int maxLen = 0;
    	int  centerIndex = 0;
    	for(int i = 1; i < n - 1; i ++) {
    		int start = (i - P[i]) / 2;
    		if(start == 0) {
    			maxLen = P[i] > maxLen ? P[i] : maxLen;
    		}
    	}
    	return new StringBuilder(s.substring(maxLen)).reverse() + s;
    }
    public String preProcess(String s) {
    	int n = s.length();
    	if(n == 0) return "^$";
    	String ret = "^";
    	for(int i = 0 ; i < n ; i++) {
    		ret += "#" + s.charAt(i);
    	}
    	ret += "#$";
    	return ret;
    }
}
