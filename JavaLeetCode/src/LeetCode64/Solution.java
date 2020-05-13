/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。

 */
package LeetCode64;

public class Solution {
    public int minPathSum(int[][] grid) {
    	if(grid.length == 0	)return 0;
    	int sum = 0;
    	int R = grid.length ;
    	int C = grid[0].length;
    	for(int i = 1; i< C;i++) {
    		grid[0][i] = grid[0][i-1]+grid[0][i];
    	}
    	
    	for(int i = 1; i <R;i++) {
    		grid[i][0] = grid[i][0] + grid[i-1][0];
    	}
    	
    	for(int i = 1; i < R; i ++	) {
    		for(int j = 1; j < C ; j++) {
    			grid[i][j] = Math.min(grid[i][j]+grid[i-1][j], grid[i][j]+grid[i][j-1]);
    		}
    	}
    	return grid[R-1][C-1];
    }
}
