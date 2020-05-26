/**
 * 211. 添加与搜索单词 - 数据结构设计

设计一个支持以下两种操作的数据结构：

void addWord(word)
bool search(word)
search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。

示例:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
 */
package LeetCode211;

public class Solution {

}

class WordDictionary {
	class TrieNode{
		TrieNode[] children;
		boolean flag;
		
		public TrieNode() {
			children = new TrieNode[26];
			flag = false;
			for(int i = 0; i < 26;i++) {
				children[i] = null;
			}
		}
	}
	TrieNode root;
	
	
    /** Initialize your data structure here. */
    public WordDictionary() {
    	root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
    	char[] arr = word.toCharArray();
    	TrieNode cur  = root;
    	for(int i = 0; i < arr.length;i++) {
    		if(cur.children[arr[i] - 'a'] == null) cur.children[arr[i] - 'a'] = new TrieNode();
    		cur = cur.children[arr[i] - 'a'];
    	}
    	cur.flag = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	return searchHelp(word,root);
    }
    private boolean searchHelp(String word, TrieNode root) {
    	char[] arr = word.toCharArray();
    	TrieNode cur = root;
    	for(int i = 0; i < arr.length;i++) {
    		if(arr[i] == '.') {
    			for(int j = 0;j<26;j++) {
    				if(cur.children[j] !=null) {
    					if(searchHelp(word.substring(i+1), cur.children[j])) return true;
    				}
    			}
    			return false;
    		}
    		if(cur.children[arr[i] - 'a'] == null) return false;
    		cur = cur.children[arr[i] - 'a'];
    	}
    	return cur.flag;
    }
}