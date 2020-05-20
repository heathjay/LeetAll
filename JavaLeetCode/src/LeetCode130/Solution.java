/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

示例:

X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：

X X X X
X X X X
X X X X
X O X X
解释:

被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/surrounded-regions
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode130;

import java.util.Stack;

public class Solution {
	/**
	 * dfs递归
	 * @param board
	 */
    public void solve(char[][] board) {
    	if(board == null || board.length == 0) return;
    	int m = board.length;
    	int n = board[0].length;
    	for(int i = 0; i < m ; i ++) {
    		for(int j = 0; j < n;j++) {
    			boolean isEdge = i == 0 || j == 0|| i == m-1|| j == n-1;
    			if(isEdge && board[i][j] == '0') dfs(board, i ,j );
    		}
    	}
    	
    	for(int i = 0; i < m;i++) {
    		for(int j = 0; j < n; j++) {
    			if(board[i][j] == '0') board[i][j] = 'X';
    			if(board[i][j] == '#') board[i][j] = '0';
    		}
    	}
    }
    public void dfs(char[][] board, int i, int j) {
    	if(i < 0 || j < 0 || i >= board.length || j>= board[0].length || board[i][j] == 'X' || board[i][j] == '#') return ; 
    	board[i][j] = '#';
    	dfs(board, i + 1, j);
    	dfs(board, i - 1, j);
    	dfs(board, i, j - 1);
    	dfs(board, i, j + 1);
    }
    /**
     * dfs非
     * @param board
     */
    public class Pos{
    	int i ;
    	int j ;
    	Pos(int i, int j){
    		this.i = i;
    		this.j = j;
    	}
    }
    public void solve1(char[][] board) {
    	if(board == null || board.length == 0) return ;
    	int m = board.length;
    	int n = board[0].length;
    	for(int i = 0; i < m; i++) {
    		for(int j = 0; j < n ; j++) {
    			boolean isEdge = i == 0 || j == 0|| i == m-1 || j == n-1;
    			if(isEdge && board[i][j] == 'O') dfs1(board, i ,j );
    		}
    	}
    	
    	for(int i = 0 ; i < m ; i++) {
    		for(int j = 0; j < n ; j++) {
    			if(board[i][j] == 'O') board[i][j] = 'X';
    			if(board[i][j] == '#') board[i][j] = 'O';
    		}
    	}
    }
    public void dfs1(char[][] board, int i , int j) {
    	Stack<Pos> stack = new Stack<>();
    	stack.push(new Pos(i,j));
    	while(!stack.isEmpty()) {
    		Pos current = stack.peek();
    		//上
    		if(current.i - 1 > 0 && board[current.i - 1][current.j] == 'O')  {
    			stack.push(new Pos(current.i-1,current.j));
    			board[current.i-1][current.j] = '#';
    			continue;
    		}
    		//下
    		if(current.i + 1 > 0 && board[current.i + 1][current.j] == 'O')  {
    			stack.push(new Pos(current.i+1,current.j));
    			board[current.i+1][current.j] = '#';
    			continue;
    		}
    		//左
    		if(current.j - 1 > 0 && board[current.i][current.j - 1] == 'O')  {
    			stack.push(new Pos(current.i,current.j - 1));
    			board[current.i][current.j - 1] = '#';
    			continue;
    		}
    		
    		//右
    		if(current.j + 1 > 0 && board[current.i][current.j + 1] == 'O')  {
    			stack.push(new Pos(current.i,current.j + 1));
    			board[current.i][current.j + 1] = '#';
    			continue;
    		}
    		stack.pop();
    	}
    }
    
    
    
}
