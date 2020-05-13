/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
示例 1:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
输出: true
示例 2:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13

链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 */
package LeetCode74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int R = matrix.length;
    	if(R == 0 ) return false;
    	int C = matrix[0].length ;
    	if(C == 0 ) return false;
    	for(int i = 0;i < R;i++	 ) {
    		if(matrix[i][0] <= target && matrix[i][C-1] >= target) {
    			int left = 0, right = C-1;
    			while(left<= right) {
    				int mid = (left+right) /2;
    				if(matrix[i][mid] < target) {
    					left = mid+1;
    				}else if(matrix[i][mid] > target) {
    					right = mid-1;
    				}else if(matrix[i][mid] == target) {
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }
}
