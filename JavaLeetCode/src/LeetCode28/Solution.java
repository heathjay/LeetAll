/**
 * 实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-strstr
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode28;

public class Solution {
	public int strStr(String haystack, String needle) {
		int res = -1;
		if(haystack == null||haystack.length() == 0 || haystack.length() < needle.length()) return res;
		for(int i = 0 ; i < haystack.length() - needle.length(); i ++) {
			String tem = haystack.substring(i,i+needle.length());
			System.out.println(tem);
			if(tem == needle) {
				res = i;
				return res;
			}
		}
		return res;
    }
	/**
	 * 双指针
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr1(String haystack, String needle) {
		int L = needle.length();
		int n = haystack.length();
		if(L==0) return 0;
		int pn = 0;
		while(pn<n-L +1) {
			while(pn < n - L +1 && haystack.charAt(pn) != needle.charAt(0)) pn++;
			
			int currLen = 0, pL = 0;
			while(pL <L && pn<n && haystack.charAt(pn) == needle.charAt(pL)) {
				pn++;
				pL++;
				currLen++;
			}
			
			if(currLen == L)return pn - L;
			pn = pn - currLen +1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String str = "hello";
		String ss = "ll";
		Solution s = new Solution();
		s.strStr(str, ss);
	}
}
