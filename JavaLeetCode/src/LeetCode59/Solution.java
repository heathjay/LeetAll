/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

 */
package LeetCode59;

public class Solution {
    public int[][] generateMatrix(int n) {
    	int[][] res = new int[n][n];
    	if(n==0)return res;
    	
    	boolean[][] used = new boolean[n][n];
    	int[] dr = {0, 1, 0, -1};
    	int[] dc = {1, 0, -1, 0};
    	int di = 0;
    	int row = 0, col = 0;
    	
    	for(int i = 0; i < n * n ; i++) {
    		res[row][col] = i;
    		used[row][col] = true;
    		int cr = row + dr[di];
    		int cc = col + dc[di];
    		if(cr >= 0 && cr < n && cc < n && cc >=0 && !used[cr][cc]) {
    			row = cr;
    			col = cc;
    		}else {
   				 di = (di + 1)%4;
   				 row += dr[di];
   				 col += dc[di];
    		}
    	}
    	return res;
    }
}
