/**
 * 208. 实现 Trie (前缀树)
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
示例:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");   
trie.search("app");     // 返回 true
 */
package LeetCode208;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

}
class Trie1 {
	Set<String> Subset;
	Set<String> set;
    /** Initialize your data structure here. */
    public Trie1() {
    	set = new HashSet<>();
    	Subset = new HashSet<>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	for(int i =0 ; i <= word.length();i++) {
    		String key =word.substring(0,i);
    		Subset.add(key);
    	}
    	set.add(word);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	if(set.contains(word))return true;
    	return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	if(Subset.contains(prefix)) return true;
    	return false;
    }
}

class TrieNode{
	private TrieNode[] links;
	private final int R = 26;
	private boolean isEnd;
	public TrieNode() {
		links = new TrieNode[R];
	}
	public boolean containKey(char ch) {
		return links[ch - 'a'] != null;
	}
	public TrieNode get(char ch) {
		return links[ch - 'a'];
	}
	public void put(char ch, TrieNode node) {
		links[ch - 'a'] = node;
	}
	public void setEnd() {
		isEnd = true;
	}
	public boolean isEnd() {
		return isEnd;
	}
}

class Trie {
	private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
    	root = new TrieNode()	;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode node = root;
    	for(int i = 0; i < word.length();i++) {
    		char curr = word.charAt(i);
    		if(!node.containKey(curr)) node.put(curr, new TrieNode());
    		node = node.get(curr);
    	}
    	node.setEnd();
    }
    
    private TrieNode searchPrefix(String word) {
    	TrieNode node =root ;
    	for(int i = 0; i < word.length();i++) {
    		char cur = word.charAt(i);
    		if(node.containKey(cur)) node = node.get(cur);
    		else return null;
    	}
    	return node;
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode node =searchPrefix(word);
    	return node != null && node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode node =searchPrefix(prefix);
    	return node != null;
    }
}