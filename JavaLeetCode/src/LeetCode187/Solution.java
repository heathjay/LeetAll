/**
 * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。

编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。

 

示例：

输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
输出：["AAAAACCCCC", "CCCCCAAAAA"]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/repeated-dna-sequences
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	/**
	 * set 加上数组
	 * @param s
	 * @return
	 */
    public List<String> findRepeatedDnaSequences(String s) {
    	int L = 10, n = s.length();
    	HashSet<String> seen = new HashSet(), output = new HashSet();
    	for(int start = 0; start < n - L + 1; start++) {
    		String tmp = s.substring(start,start+L);
    		if(seen.contains(tmp)) output.add(tmp);
    		seen.add(tmp);
    	}
    	return new ArrayList<String>(output);
    }
    
    public List<String> findRepeatedDnaSequences1(String s) {
    	int L = 10, n = s.length()	;
    	int a = 4, aL = (int) Math.pow(a, L);
    	Map<Character,Character> toInt = new HashMap() {
    		{
    			put('C',1);
    			put('A',0);
    			put('G',2);
    			put('T',3);
    		}
    	};
    	int[] nums = new int[n];
    	for(int i = 0; i < n;i++) nums[i] = toInt.get(s.charAt(i));
    	int h = 0;
    	Set<Integer> seen = new HashSet();
    	Set<String> output = new HashSet();
    	for(int start = 0; start < n - L +1;start++) {
    		if(start != 0)
    			h = h *a - nums[start-1] * aL + nums[start + L -1];
    		else 
    			for(int i = 0; i <L ; i++) h = h * a + nums[i];
    		if(seen.contains(h))output.add(s.substring(start,start+L));
    		seen.add(h);
    	}
    	return new ArrayList<String>(output);
    }
}
