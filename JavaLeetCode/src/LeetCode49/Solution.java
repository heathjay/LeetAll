package LeetCode49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> res = new ArrayList<>();
		 Map<Integer,Integer> maps = new HashMap<>();
		 int len = strs.length;
		 for(int i = 0 ; i < len; i++) {
			 Map<Character,Integer> map = new HashMap<>();
			 for(int j = 0 ; j < strs[i].length();j++) {
				 map.put(strs[i].charAt(j), map.getOrDefault(strs[i].charAt(j), 0) + 1);
			 }
			 if(maps.containsKey(map.hashCode())) {
				 res.get(maps.get(map.hashCode())).add(strs[i]);
				 System.out.println(map.hashCode());
				 System.out.println(map);
				 System.out.println(strs[i]);
				 
			 }else {
				 maps.put(map.hashCode(), maps.size());
				 List<String> list = new ArrayList<>();
				 list.add(strs[i]);
				 res.add(list);
			 }
		 }
		 return res;
    }
    
    public List<List<String>> groupAnagrams1(String[] strs){
    	if(strs.length == 0) return null;
    	Map<String,List> res = new HashMap<>();
    	for(String str: strs) {
    		char[] c = str.toCharArray();
    		Arrays.sort(c);
    		String key = String.valueOf(c);
    		if(!res.containsKey(key)) res.put(key, new ArrayList());
    		res.get(key).add(str);
    	}
    	return new ArrayList(res.values());
    }
    
    public  List<List<String>> groupAnagrams2(String[] strs){
    	if(strs.length == 0) return null;
    	Map<String,List> res = new HashMap<>();
    	int[] count = new int[26];
    	
    	for(String s : strs) {
    		Arrays.fill(count, 0);
    		for(char c : s.toCharArray()) count[c-'a']++;
    		StringBuilder sb = new StringBuilder("");
    		for(int i = 0 ; i < 26;i++) {
    			sb.append('#');
    			sb.append(count[i]);
    		}
    		String key = sb.toString();
    		if(!res.containsKey(key)) res.put(key, new ArrayList());
    		res.get(key).add(s);
    	}
    	return new ArrayList(res.values());
    }
    public static void main(String[] args) {
    	Solution s =new Solution();
    	String[] str = {"apt","man","qom","apt","lei","hus","pet","gay","six","mai"};
    	System.out.println(s.groupAnagrams(str));
    }
}