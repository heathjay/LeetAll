/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/spiral-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	  public List<Integer> spiralOrder(int[][] matrix) {
		 List res = new ArrayList();
		 if(matrix.length == 0) return res;
		 int R = matrix.length, C = matrix[0].length;
		 boolean[][] seen = new boolean[R][C];
		 int[] dr = {0,1,0,-1};
		 int[] dc = {1,0,-1,0};
		 int r= 0, c=0,di=0;
		 for(int i = 0; i < R*C;i++) {
			 res.add(matrix[r][c]);
			 seen[r][c] = true;
			 int cr = r + dr[di];
			 int cc =c + dc[di];
			 if(0<= cr && cr < R && 0<= cc && cc<C && !seen[cr][cc]) {
				 r= cr;
				 c =cc;
			 }else {
				 di = (di + 1)%4;
				 r += dr[di];
				 c += dc[di];
			 }
		 }
		 return res;
	   }
	  
	  public List<Integer> s(int[][] matrix){
		  List res = new ArrayList();
		  if(matrix.length == 0) {
			  return res;
		  }
		  int r1 = 0, r2 = matrix.length -1;
		  int c1 = 0, c2 = matrix[0].length -1;
		  while(r1<= r2 && c1<=c2) {
			  for(int c = c1; c <= c2;c++) {
				  res.add(matrix[r1][c]);
			  }
			  
			  for(int r = r1 + 1; r <= r2; r++) {
				  res.add(matrix[r][c2]);
			  }
			  
			  if(r1 < r2 && c1 <= c2) {
				  for(int c = c2 -1;c > c1; c--)res.add(matrix[r2][c]);
				  for(int r = r2; r > r1; r--) res.add(matrix[r][c1]);
			  }
			  r1++;
			  r2--;
			  c1++;
			  c2--;
		  }
		  return res;
	  }
}
