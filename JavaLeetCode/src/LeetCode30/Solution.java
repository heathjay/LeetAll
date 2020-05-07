/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。

注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

 

示例 1：

输入：
  s = "barfoothefoobarman",
  words = ["foo","bar"]
输出：[0,9]
解释：
从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。
示例 2：

输入：
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
输出：[]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	 public static  List<Integer> findSubstring(String s, String[] words) {
		 if(words.length == 0 || s == null) return null;
		 Map<String, Integer> mapWords = new HashMap<String,Integer>();
		 for(int i = 0; i< words.length;i++) {
			 mapWords.put(words[i], i);
		 }
		 Map<Integer,String> re = new HashMap<Integer, String>();
		 List<Integer> res = new ArrayList<Integer>();
		 int len = words[0].length();
		 int size = 0;
		 int i = 0;
		
		 while(i < s.length() - len + 1) {
			 
			 if(mapWords.containsKey(s.substring(i, i + len))) {
				
				if(!re.containsValue(s.substring(i,i+len))) {
					re.put(size, s.substring(i, i + len));
					size++;
					if(size == words.length) {
						res.add(i-len*(words.length-1));
						i = i-len*(words.length - 2);
						size = 0;
						re.clear();
					}else {
						i = i + len;
					}
				
				}else {
					i = i - size*len +1;
					size = 0;
					re.clear();
				}
				
			 }else {
				 i++;
			 } 
		 }
		 
		 return res;
	   }
	 public static List<Integer> find(String s, String[] words){
		 List<Integer>	res = new ArrayList<Integer>();
		 if(words.length == 0 || s == null || s.length() == 0 || words == null) return res;
		 HashMap<String,Integer> map = new HashMap<String,Integer>();
		 int one_word = words[0].length();
		 int word_num = words.length;
		 
		 int all_len = one_word * word_num;
		 
		 for(String word : words) {
			 map.put(word, map.getOrDefault(word, 0) + 1);
		 }
		 for(int i = 0; i < s.length() - all_len + 1;i++) {
			 String temp = s.substring(i, i+all_len);
			 HashMap<String,Integer> temp_map= new HashMap<>();
			 for(int j = 0; j < all_len; j += one_word) {
				 String w = temp.substring(j, j + one_word);
				 temp_map.put(w, temp_map.getOrDefault(w, 0) + 1);
			 }
			 if(map.equals(temp_map)) res.add(i);
		 }
		 
		 
		 return res;
		 
		 
	 }
	 public static void main(String[] args) {
	/*	 String s= "barfoothefoobarman";
		 String[] words = {
				 "foo","bar"
				 };
		 */
		 String s= "barfoofoobarthefoobarman";
		 String[] words = {
				
				 "bar","foo","the"
				 };
		 System.out.println(findSubstring(s,words));
		 //System.out.println(s.substring(0, 0+words[0].length()));
				 
	 }
}
