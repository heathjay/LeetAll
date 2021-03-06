/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。

说明：

分隔时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
输出:
[
  "cats and dog",
  "cat sand dog"
]
示例 2：

输入:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
输出:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
解释: 注意你可以重复使用字典中的单词。
示例 3：

输入:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
输出:
[]


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-break-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode140;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
	/**
	 * 记忆性回溯
	 * @param s
	 * @param wordDict
	 * @return
	 */
    public List<String> wordBreak(String s, List<String> wordDict) {
    	return word_break(s,wordDict,0);
    }
    HashMap<Integer, List<String>> map = new HashMap<>();
    public List<String> word_break(String s, List<String> wordDict, int start){
    	if(map.containsKey(start)) return map.get(start);
    	LinkedList<String> res = new LinkedList<>();
    	if(start == s.length()) res.add("");
    	for(int end = start + 1; end <= s.length();end++) {
    		if(wordDict.contains(s.substring(start,end))) {
    			List<String> list = word_break(s, wordDict, end);
    			for(String l : list) res.add(s.substring(start,end) +( l.equals("") ? "" :" ") + l);
    		}
    	}
    	map.put(start, res);
    	return res;
    }
    /**
     * 动态规划
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak1(String s, List<String> wordDict) {
    	LinkedList<String>[] dp = new LinkedList[s.length() + 1];
    	LinkedList<String> initial = new LinkedList<>();
    	initial.add("");
    	dp[0] = initial;
    	for(int i = 1; i <= s.length();i++) {
    		LinkedList<String> list = new LinkedList<>();
    		for(int j = 0; j <i; j++) {
    			if(dp[j].size() >0 && wordDict.contains(s.substring(j,i))) {
    				for(String l : dp[j]) list.add(l + (l.equals("") ? "" :" ") + s.substring(j,i));
    			}
    		}
    		dp[i]= list;
    	}
    	return dp[s.length()];
    }
}
