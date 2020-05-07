/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-sudoku
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

输入:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-sudoku
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode36;

import java.util.HashMap;

public class Solution {
	public boolean isValidSudoku(char[][] board) {
		HashMap<Integer, Integer>[] box = new HashMap[9];
		HashMap<Integer, Integer>[] column = new HashMap[9];
		HashMap<Integer, Integer>[] row = new HashMap[9];
		
		for(int i =0; i < 9 ; i++) {
			box[i] = new HashMap<Integer,Integer>();
			row[i] = new HashMap<Integer,Integer>();
			column[i] = new HashMap<Integer,Integer>();
		}
		
		for(int i = 0 ;i < 9; i ++) {
			for(int j = 0; j < 9 ;j++) {
				char nums = board[i][j];
				if(nums != '.') {
					int boxInx = 3*(i/3) + j/3;
					int n = (int) nums;
					row[i].put(n, row[i].getOrDefault(n, 0) + 1);
					column[j].put(n, column[j].getOrDefault(n, 0) + 1);
					box[boxInx].put(n, box[boxInx].getOrDefault(n, 0)+1);
					
					if(row[i].get(n) > 1 || column[j].get(n) > 1 || box[boxInx].get(n) > 1) {
						return false;
					}
				}
			}
		}
		return true;
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
