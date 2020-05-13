/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

示例 1:

输入: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
示例 2:

输入: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
输出: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/set-matrix-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode73;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public void setZeroes(int[][] matrix) {
    	Set<Integer> Rset = new HashSet<>();
    	Set<Integer> Cset = new HashSet<>();
    	int R = matrix.length;
    	int C = matrix[0].length;
    	for(int i = 0; i <R;i++) {
    		for(int j =0; j <C;j++ ) {
    			  if(matrix[i][j] == 0){
    					Rset.add(i);
    	    			Cset.add(j); 
    			  }
    		
    		}
    	}
    	for(int i =0;i < R;i++) {
    		for(int j = 0; j < C;j++) {
    			if(Rset.contains(i) || Cset.contains(j)) {
    				matrix[i][j]= 0;
    			}
    		}
    	}
    }
    
}
