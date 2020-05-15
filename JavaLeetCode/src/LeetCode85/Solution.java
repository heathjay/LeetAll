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

import java.util.Arrays;

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
    
   //也可以通过84的栈，动态规划把前面的规划成自己的列
    
    public int  dd(char[][] matrix) {
    	if(matrix.length == 0) return 0;
    	int m = matrix.length;
    	int n = matrix[0].length;
    	
    	int[] left = new int[n];
    	int[] right = new int[n];
    	int[] height = new int[n];
    	
    	Arrays.fill(right, n);
    	int maxarea = 0;
    	
    	for(int i =0;i <m;i++) {
    		int cur_left = 0, cur_right = n;
    		
    		for(int j = 0; j <n; j++) {
    			if(matrix[i][j] == '1') height[j]++;
    			else height[j] = 0;
    		}
    		for(int j =0;j<n;j++) {
    			if(matrix[i][j] == '1') left[j] = Math.min(left[j], cur_left);
    			else {
    				left[j] = 0;
    				cur_left = j+1;
    			}
    		}
    		for(int j = n-1;j >=0;j--) {
    			if(matrix[i][j] == '1')right[j] = Math.min(right[j]	, cur_right	);
    			else {
    				right[j] = n;
    				cur_right = j;
    			}
    		}
    		
    		for(int j = 0; j < n;j++) {
    			maxarea = Math.max(maxarea, (right[j]- left[j]) *height[j]);
    		}
    	}
    	return maxarea;
    }
}
