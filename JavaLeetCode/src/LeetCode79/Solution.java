/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode79;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
	private int[][] dd = {{-1,0},{0,-1},{0,1},{1,0}};
	private boolean[][] marked ;
	int n;
	int m;
	private String word;
	private char[][] board;

	public boolean exist(char[][] board, String word) {
		m = board.length;
		if(m==0) {
			return false;
		}
		n = board[0].length;
		if(n==0) {
			return false;
		}
		marked = new boolean[m][n];
		this.word = word;
		this.board = board;
		
		for(int i = 0;i < m ;i++) {
			for(int j = 0; j < n ; j++) {
				if(dfs(i,j,0)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean dfs(int i, int j, int start) {
		if(start == word.length() - 1) {
			return board[i][j] == word.charAt(start);
		}
		if(board[i][j] == word.charAt(start)) {
			marked[i][j] = true;
			for(int k = 0 ; k < 4;k++) {
				int newX = i+dd[k][0];
				int newY = j + dd[k][1];
				if(inArea(newX, newY) && !marked[newX][newY]) {
					if(dfs(newX,newY, start+1)) {
						return true;
					}
				}
			}
			marked[i][j] = false;
		}
		return false;
	}
	
	private boolean inArea(int x, int y) {
		return x >=0 && x<m && y>=0 && y<n;
	}
}
