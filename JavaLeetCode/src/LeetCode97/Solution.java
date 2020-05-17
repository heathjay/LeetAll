/**
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。

示例 1:

输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
输出: true
示例 2:

输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/interleaving-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode97;

public class Solution {
	/**
	 * 暴力法,res携带上面结果,
	 * 时间太长
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
    public boolean isInterleave1(String s1, String s2, String s3) {
    	return is_Interleave1(s1,0,s2,0,"",s3);
    }
    public boolean is_Interleave1(String s1, int i, String s2, int j, String res, String s3) {
    	if(res.equals(s3) && i == s1.length() && j == s2.length()) {
    		return true;
    	}
    	boolean ans = false;
    	if(i<s1.length())
    		ans |= is_Interleave1(s1,i+1,s2,j,res+s1.charAt(i),s3);
    	if(j<s2.length())
    		ans |= is_Interleave1(s1,i,s2,j+1,res+s2.charAt(j),s3);
    	return ans;
    }
    /**
     * 记忆重复
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
    	int memo[][] = new int[s1.length()][s2.length()];
    	for(int i = 0; i < s1.length(); i++) {
    		for(int j = 0; j < s2.length() ; j++) {
    			memo[i][j] = -1;
    		}
    	}
    	return is_Interleave(s1,0,s2,0,s3,0,memo);
    }
    public boolean is_Interleave(String s1, int i, String s2, int j, String s3, int k, int[][] memo) {
    	if(i == s1.length())
    		return s2.substring(j).equals(s3.substring(k));
    	if(j == s2.length())
    		return s1.substring(i).equals(s3.substring(k));
    	if(memo[i][j] >=0) {
    		return memo[i][j] == 1? true:false;
    	}
    	boolean ans = false;
    	if(s3.charAt(k) == s1.charAt(i) && is_Interleave(s1,i+1,s2,j,s3,k+1,memo) || s3.charAt(k) == s2.charAt(j) && is_Interleave(s1,i,s2,j+1,s3,k+1,memo)) {
    		ans = true;
    	}
    	memo[i][j] = ans?1:0;
    	return ans;
    }
    /**
     * 
     * @param s1
     * @return
     */
    public boolean isInter1leave2(String s1, String s2, String s3) {
    	if(s3.length() != s1.length() + s2.length())
    		return false;
    	boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
    	
    	for(int i = 0;i <= s1.length(); i++) {
    		for(int j = 0; j <= s2.length();j++) {
    			if(i == 0 && j == 0) {
    				dp[i][j] = true;
    			}else if(i==0) {
    				dp[i][j]= dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i + j -1);
    			}else if(j == 0) {
    				dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i + j -1);
    			}else {
    				dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i + j -1)));
    			}
    			
    		}
    	}
    	return dp[s1.length()][s2.length()];
    }
}
