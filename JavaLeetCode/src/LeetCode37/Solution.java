/**
 * 编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sudoku-solver
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode37;

public class Solution {
	/**
	 * 约束编程
	 * - 放置每一个数字时都设置约束条件，在熟读上放置一个数字后立即排除当前行列和字块对该数字的使用，这回传播约束条件，并有利于减少需要考虑组合的个数
	 * 
	 * 回溯
	 * - 成功放置的数字，并不最优且不能继续放置数字了，该怎么办？ 回溯
	 * 回退回来，来改变放置的数字并且继续尝试
	 * @param board
	 */
	
	int n = 3;
	int N = n * n;
	
	int[][] rows = new int[N][N+1];
	int[][] columns = new int[N][N+1];
	int[][] boxes = new int[N][N+1];
	
	char[][] board;
	
	boolean sudokuSolved = false;
	

	 public void solveSudoku(char[][] board) {
		 this.board = board;
		 
		 for(int i = 0; i < N; i ++) {
			 for( int j = 0 ; j < N ; j++) {
				 char num = board[i][j];
				 if(num != '.') {
					 int d = Character.getNumericValue(num);
					 placeNumber(d,i,j);
				 }
			 }
		 }
		 backtrack(0,0);
	  }
	 /**
	  * 放数字进入row,col,box中
	  * - 一维度是列号和行号，
	  * - 第二维度是数字，
	  * 
	  * @param d
	  * @param row
	  * @param col
	  */
	 public void placeNumber(int d, int row, int col) {
		 int boxIndx = 3 * ( row / 3) + col/3;
		 rows[row][d]++;
		 columns[col][d]++;
		 boxes[boxIndx][d]++;
		 
		 board[row][col] = (char)(d+'0');
	 }
	 
	 
	 public void backtrack(int row,int col) {
		 if(board[row][col] == '.') {
			 for(int d = 1; d < 10; d++) {
				 if(couldPlace(d,row,col)) {
					 placeNumber(d,row,col);
					 placeNextNumber(row,col);
					 if(!sudokuSolved) removeNumber(d,row,col);
				 }
			 }
		 }
		 else {
			 placeNextNumber(row,col);
		 }
	 }
	 public void removeNumber(int d, int row, int col) {
		 int idx = (row / n) * n + col / n;
		 rows[row][d]--;
		 columns[col][d]--;
		 boxes[idx][d]--;
		 board[row][col] = '.';
	 }
	 public void placeNextNumber(int row,int col) {
		 if((col == N -1) && (row == N-1)) {
			 sudokuSolved = true;
		 }else {
			 if(col == N -1) backtrack(row+1,0);
			 else backtrack(row,col+1);
		 }
	 }
	 
	 public boolean couldPlace(int d, int row,int col) {
		 int idx = (row/n) *n + col/n;
		 return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
	 }
}
