/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

 

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/triangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode120;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if(triangle == null || triangle.size() == 0) {
    		return 0;
    	}
    	int row = triangle.size();
    	int column = triangle.get(row-1).size();
    	
    	int[][] dp = new int[row][column];
    	dp[0][0] = triangle.get(0).get(0);
    	int res = Integer.MAX_VALUE;
    	
    	for(int i = 1; i < row; i++) {
    		for(int j = 0; j <= i; j++	) {
    			if(j == 0) dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
    			else if(j == i)dp[i][j]= dp[i-1][j-1] + triangle.get(i).get(j);
    			else dp[i][j]= Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
    		}
    	}
    	
    	for(int i = 0; i < column;i++	) {
    		res = Math.min(res, dp[row-1][i]);
    	}
    	return res;
    }
}
