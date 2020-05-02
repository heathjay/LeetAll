package LeetCode5_huiwen;
/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jay
 *
 */
public class Solution {
/**
 * 中心突破， 
 * - 循环从头开始
 * - 两种：
 * 	- 奇数：两边突破，同时开始
 * 	- 偶数： 一左一右
 * - start: 不包含当前
 * - end：偶数时包含当前
 * - substring左包含
 * @param s
 * @return
 */
	public static String longestPalindrome(String s) {
		if(null == s || s.length() == 0) {
			return " ";
		}
		int strLen = s.length();
		int start = 0 , end = 0;
		
		for(int i = 0; i < strLen; i ++) {
			int len1 = find(s,i,i);
			int len2 = find(s,i,i+1);
			int len = Math.max(len1, len2);
			if(len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end +1);
    }
	
	public static int find(String s, int left, int right) {
		while(left >=0 && right <= s.length()-1 && s.charAt(left) == s.charAt(right)) {
			left -- ;
			right ++;
		}
		return right - left - 1;
		
	}
	/**
	 * 动态规划
	 * @param args
	 */
	public static String dynamic(String s) {
		String origin = s;
		String reverse = new StringBuffer(s).reverse().toString();
		int length = s.length();
		int[][] arr = new int[length][length];
		int maxLen = 0;
		int maxEnd = 0;
		if(s == null || length == 0){
            return "";
        }
		for(int i = 0; i < length ; i ++ ) {
			for(int j = 0; j< length ; j ++ ) {
				if(origin.charAt(i) == reverse.charAt(j)) {
					if(i==0 || j == 0) {
						arr[i][j] = 1;
					}else {
						arr[i][j] = arr[i-1][j-1] + 1;
					}
					
					if (arr[i][j] > maxLen) {
		                int beforeRev = length - 1 - j;
		                if (beforeRev + arr[i][j] - 1 == i) { //判断下标是否对应
		                    maxLen = arr[i][j];
		                    maxEnd = i;
		                }
					
					}
				}
			
			}
		}
	
		return s.substring(maxEnd - maxLen + 1, maxEnd + 1); 
	}
	public static void main(String[] args) {
		String str = "aacdefcaa";
		System.out.println(dynamic(str));
	}

}
