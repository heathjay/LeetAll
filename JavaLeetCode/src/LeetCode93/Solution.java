/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。

 

示例:

输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/restore-ip-addresses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode93;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	int n;
	String s;
	LinkedList<String> segments = new LinkedList<String>();
	ArrayList<String> output = new ArrayList<String>();
	
	public boolean valid(String segment) {
		int m = segment.length();
		if(m > 3) {
			return false;
		}
		return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : m == 1;
	}
	
	public void update_ouput(int curr_pos) {
		String segment = s.substring(curr_pos + 1 , n);
		if(valid(segment)) {
			segments.add(segment);
			output.add(String.join(".", segments));
			segments.removeLast();
		}
	}
	
	public void backtrack(int prev_pos, int dots) {
		int max_pos = Math.min(n-1, prev_pos + 4);
		for(int curr_pos = prev_pos + 1; curr_pos < max_pos; curr_pos++) {
			String segment = s.substring(prev_pos + 1, curr_pos + 1	);
			if(valid(segment)) {
				segments.add(segment);
				if(dots - 1== 0) {
					update_ouput(curr_pos);
				}else {
					backtrack(curr_pos, dots-1);
				}
				segments.removeLast();
			}
		}
	}
    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        this.s = s;
        backtrack(-1,3);
        return output;
    }
}
