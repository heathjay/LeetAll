/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

示例:

输入:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
输出: 6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximal-rectangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode85;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
    	if(matrix.length == 0) return 0;
    	int maxarea = 0;
    	int[][] dp = new int[matrix.length][matrix[0].length];
    	
    	for(int i = 0; i < matrix.length;i++) {
    		for(int j =0; j < matrix[0].length;j++) {
    			if(matrix[i][j] == '1') {
    				dp[i][j] = j == 0?1:dp[i][j-1]+1;
    				int width = dp[i][j];
    				for(int k = i; k >= 0;k--) {
    					width = Math.min(width, dp[k][j]);
    					maxarea = Math.max(maxarea, width *(i-k+1));
    				}
    			}
    		}
    	}
    	return maxarea;
    }
}
