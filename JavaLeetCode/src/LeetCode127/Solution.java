/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: 0

解释: endWord "cog" 不在字典中，所以无法进行转换。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-ladder
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode127;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.util.Pair;

public class Solution {
	/**
	 * 深度
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length()	;
        Map<String, List<String>> allDict = new HashMap<>();
        wordList.forEach(
        		word->{
        			for(int i = 0; i < L;i++) {
        				String newWord = word.substring(0,i) + '*' + word.substring(i+1, L);
        				List<String> transformations = allDict.getOrDefault(newWord, new ArrayList<>());
        				transformations.add(word);
        				allDict.put(newWord, transformations);
        			}
        		});
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord,1));
        
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        
        while(!Q.isEmpty()) {
        	Pair<String, Integer> node = Q.remove()	;
        	String word = node.getKey()	;
        	int level = node.getValue()	;
        	for(int i = 0; i < L; i++) {
        		String newWord = word.substring(0,i) + '*' + word.substring(i+1,L);
        		for(String adjacentWord : allDict.getOrDefault(newWord, new ArrayList<>())) {
        			if(adjacentWord.equals(endWord)) return level + 1;
        			if(!visited.containsKey(adjacentWord)) {
        				visited.put(adjacentWord, true);
        				Q.add(new Pair(adjacentWord, level + 1));
        			}
        		}
        	}
        }
        return 0;
    }
    /**
     * 广度遍历
     */
    private int L;
    private Map<String, List<String>> allComboDict;
    Solution(){
    	this.L = 0;
    	this.allComboDict = new HashMap<>();
    }
    private int visitWordNode(
    		Queue<Pair<String, Integer>> Q,
    		Map<String, Integer> visisted,
    		Map<String, Integer> othersVisited
    		) {
    	Pair<String, Integer> node = Q.remove()	;
    	String word = node.getKey()	;
    	int level = node.getValue();
    	for(int i = 0; i <this.L; i++) {
    		String newWord = word.substring(0,i) + '*'+word.substring(i+1,L);
    		for(String adjacentWord : this.allComboDict.getOrDefault(newWord, new ArrayList<>())) {
    			if(othersVisited.containsKey(adjacentWord)) {
    				return level + othersVisited.get(adjacentWord);
    			}
    			if(!visisted.containsKey(adjacentWord)) {
    				visisted.put(adjacentWord, level +1);
    				Q.add(new Pair(adjacentWord,level+1));
    			}
    		}
    	}
    	return -1;
    }
    public int ladderlength(String beginWord, String endWord, List<String> wordList) {
    	if(!wordList.contains(endWord)) return 0;
    	this.L = beginWord.length();
    	wordList.forEach(
    			word -> {
    				for(int i = 0; i < L ; i++) {
    					String newWord = word.substring(0,i) + '*'+word.substring(i+1,L);
    					List<String> t = this.allComboDict.getOrDefault(newWord, new ArrayList<>());
    					t.add(word);
    					this.allComboDict.put(newWord, t);
    				}
    			}
    			);
    	Queue<Pair<String,Integer>> Q_begin = new LinkedList<>();
    	Queue<Pair<String, Integer>> Q_end = new LinkedList<>();
    	Q_begin.add(new Pair(beginWord, 1));
    	Q_end.add(new Pair(endWord, 1));
    	
    	Map<String, Integer> visitedBegin = new HashMap<>();
    	Map<String, Integer> visitedEnd = new HashMap<>();
    	
    	visitedBegin.put(beginWord, 1);
    	visitedEnd.put(endWord, 1);
    	
    	while(!Q_begin.isEmpty() && !Q_end.isEmpty()) {
    		int ans = visitWordNode(Q_begin, visitedBegin, visitedEnd);
    		if(ans > -1) return ans;
    		ans = visitWordNode(Q_end, visitedEnd, visitedBegin);
    		if(ans > -1) return ans;
    	}
    	return 0;
    }
    
}
