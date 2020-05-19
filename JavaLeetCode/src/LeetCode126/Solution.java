/**
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回一个空列表。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: []
解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 */
package LeetCode126;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
	/**
	 * dfs 超出时间
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    	List<List<String>> ans = new ArrayList<>();
    	ArrayList<String> temp = new ArrayList<>();
    	temp.add(beginWord);
    	findLadderHelper(beginWord, endWord, wordList, temp, ans);
    	return ans;
    }
    int min = Integer.MAX_VALUE;
    private void findLadderHelper(String beginWord, String endWord, List<String> wordList, ArrayList<String> temp, List<List<String>> ans) {
    	if(beginWord.equals(endWord)) {
    		if(min > temp.size()) {
    			ans.clear();
    			min = temp.size();
    			ans.add(new ArrayList<String>(temp));
    		}else if(min == temp.size()) {
    			ans.add(new ArrayList<String>(temp));
    		}
    		return;
    	}
    	if(temp.size() >= min) {
    		return;
    	}
    	for(int i = 0; i < wordList.size();i++) {
    		String curWord = wordList.get(i);
    		if(temp.contains(curWord)) continue;
    		if(oneChanged(beginWord, curWord)) {
    			temp.add(curWord);
    			findLadderHelper(curWord, endWord, wordList, temp, ans);
    			temp.remove(temp.size() -1);
    		}
    	}
    }
    private boolean oneChanged(String beginWord, String curWord) {
    	int count = 0;
    	for(int i = 0 ; i < beginWord.length(); i ++) {
    		if(beginWord.charAt(i) != curWord.charAt(i)) {
    			count++;
    		}
    		if(count == 2) return false;
    	}
    	return count == 1;
    }
    
    
    public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        if(!wordList.contains(endWord)) return ans;
        
        HashMap<String, Integer> distance = new HashMap<>();
        HashMap<String, ArrayList<String>> map = new HashMap();
        bfs(beginWord, endWord, wordList, map, distance);
        ArrayList<String> temp = new ArrayList<String>();
        temp.add(beginWord);
        findLaddersHelper(beginWord, endWord, map, distance, temp, ans);
        return ans;
    }
    
    private void findLaddersHelper(String beginWord, String endWord, HashMap<String, ArrayList<String>> map, HashMap<String, Integer> distance, ArrayList<String> temp, List<List<String>> ans) {
    	if(beginWord.equals(endWord)) {
    		ans.add(new ArrayList<String>(temp));
    		return;
    	}
    	
    	ArrayList<String> neighbors = map.getOrDefault(beginWord, new ArrayList<String>());
    	for(String neighbor : neighbors) {
    		if(distance.get(beginWord) + 1 == distance.get(neighbor)	) {
    			temp.add(neighbor);
    			findLaddersHelper(neighbor, endWord, map, distance,temp,ans);
    			temp.remove(temp.size() - 1);
    		}
    	}
    }
    public void bfs(String beginWord, String endWord, List<String> wordList, HashMap<String,ArrayList<String>> map,HashMap<String,Integer> distance) {
    	Queue<String> queue = new LinkedList<>();
    	queue.offer(beginWord);
    	distance.put(beginWord, 0);
    	boolean isFound = false;
    	int depth = 0;
    	Set<String> dict = new HashSet<>(wordList);
    	while(!queue.isEmpty()){
    		int size = queue.size();
    		depth++;
    		for(int j = 0; j < size;j++) {
    			String temp = queue.poll();
    			ArrayList<String> neighbors = getNeighbors(temp,dict);
    			map.put(temp, neighbors);
    			for(String neighbor : neighbors) {
    				if(!distance.containsKey(neighbor)) {
    					distance.put(neighbor, depth);
    					if(neighbor.equals(endWord)) isFound =true;
    					queue.offer(neighbor);
    				}
    			}
    		}
    		if(isFound) break;
    	}
    }
    
    private ArrayList<String> getNeighbors(String node, Set<String> dict){
    	ArrayList<String> res = new ArrayList<String> ();
    	char chs[] = node.toCharArray();
    	for(char ch = 'a'; ch<='z';ch++) {
    		for(int i = 0; i < chs.length;i++) {
    			if(chs[i] == ch)
        			continue;
        		char old_ch = chs[i];
        		if(dict.contains(String.valueOf(chs))) {
        			res.add(String.valueOf(chs));
        		}
        		chs[i] = old_ch;
    		}
    		
    	}
    	return res;
    }
}
