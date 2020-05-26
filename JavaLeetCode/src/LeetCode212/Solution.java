/**
 * 212. 单词搜索 II
给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
示例:
输入: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
输出: ["eat","oath"]
 */
package LeetCode212;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	class TrieNode{
		HashMap<Character,TrieNode> children = new HashMap<>();
		String word = null;
		public TrieNode() {
			
		}
	}
	char[][] _board = null;
	ArrayList<String> _result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
    		TrieNode root = new TrieNode();
    		for(String word: words) {
    			TrieNode node = root;
    			for(Character letter: word.toCharArray()) {
    				if(node.children.containsKey(letter)) node = node.children.get(letter);
    				else {
    					TrieNode newNode = new TrieNode();
    					node.children.put(letter, newNode);
    					node = newNode;
    				}
    			}
    			node.word = word;
    		}
    		this._board = board;
    		for(int row = 0; row<board.length;row++) {
    			for(int col = 0; col <board[row].length;col++) {
    				if(root.children.containsKey(board[row][col])) backtracking(row,col,root);
    			}
    		}
    		return this._result;
    }
    private void backtracking(int row,int col, TrieNode parent) {
    	Character letter = this._board[row][col];
    	TrieNode curNode = parent.children.get(letter);
    	if(curNode.word != null) {
    		this._result.add(curNode.word);
    		curNode.word = null;
    	}
    	this._board[row][col] = '#';
    	int[] rowOffSet= {-1,0,1,0};
    	int[] colOffSet = {0,1,0,-1};
    	
    	for(int i = 0; i < 4;i++) {
    		int newRow = row + rowOffSet[i];
    		int newCol = col + colOffSet[i];
    		if(newRow <0 || newRow >= this._board.length || newCol <0 || newCol >= this._board[0].length) {
    			continue;
    		}
    		if(curNode.children.containsKey(this._board[newRow][newCol])) backtracking(newRow,newCol,curNode);
    	}
    	this._board[row][col]=letter;
    	if(curNode.children.isEmpty()) parent.children.remove(letter);
    }
}
