/**
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。

你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。

要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。

文本的最后一行应为左对齐，且单词之间不插入额外的空格。

说明:

单词是指由非空格字符组成的字符序列。
每个单词的长度大于 0，小于等于 maxWidth。
输入单词数组 words 至少包含一个单词。
示例:

输入:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
输出:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
示例 2:

输入:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
输出:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
     因为最后一行应为左对齐，而不是左右两端对齐。       
     第二行同样为左对齐，这是因为这行只包含一个单词。
示例 3:

输入:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
输出:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/text-justification
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode68;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> ans = new ArrayList<>();
    	int currLen = 0;
    	int start = 0;
    	int end = 0;
    	
    	for(int i = 0 ;i < words.length;) {
    		if(currLen == 0 && currLen + words[i].length() <= maxWidth || currLen > 0 && currLen + 1+ words[i].length() <= maxWidth) {
    			end++;
    			if(currLen == 0) {
    				currLen = currLen + words[i].length();
    			}else {
    				currLen = currLen + 1+ words[i].length();
    			}
    			i++;
    		}else {
    			int sub = maxWidth - currLen + (end - start) -1;
    			if(end - start == 1) {
    				String blank = getStringBlank(sub);
    				ans.add(words[start] + blank);
    			}else {
    				StringBuilder temp = new StringBuilder();
    				temp.append(words[start]);
    				int averageBlank = sub /((end -start) -1);
    				int missing = sub - averageBlank * ((end - start) -1);
    				
    				String blank = getStringBlank(averageBlank + 1);
    				int k = 1;
    				
    				for(int j = 0; j < missing;j++) {
    					temp.append(blank + words[start+k]);
    					k++;
    				}
    				blank = getStringBlank(averageBlank);
    				for(;k<(end - start);k++) {
    					temp.append(blank + words[start + k]);
    				}
    				
    				ans.add(temp.toString());
    			}
    			start = end;
    			currLen = 0;
    		}
    	}
    	StringBuilder temp = new StringBuilder();
    	temp.append(words[start]);
    	for(int i = 1; i < (end - start);i++) {
    		temp.append(" " + words[start + i]);
    	}
    	temp.append(getStringBlank(maxWidth - currLen));
    	ans.add(temp.toString());
    	return ans;
    	
    }
    
    private String getStringBlank(int n ) {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i <n;i++) {
    		sb.append(" ");
    	}
    	return sb.toString();
    }
}
