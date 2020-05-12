/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 非空 字符串且只包含数字 1 和 0。

 

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-binary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode67;

public class Solution {
    public String addBinary(String a, String b) {
    	int m = a.length();
    	int n = b.length();
    	if(m<n) {
    		int tmp = m;
    		m = n;
    		n= tmp;
    		
    		String tem = a;
    		a =b;
    		b = tem;
    	}
    	int pre = 0;
    	StringBuilder sb = new StringBuilder();
    	for(int i =0 ;i < m ;i++) {
    		int x = a.charAt(m -1 -i) - '0';
    		int y = i > n- 1? 0:(b.charAt(n-1-i) - '0');
    		int sum = x + y + pre;
    		
    		if(sum == 2) {
    			sb.append("0");
    			pre = 1;
    		}else if(sum == 3){
    			sb.append("1");
    			pre =1;
    		}else if(sum == 0 || sum == 1){
    			pre = 0;
    		}
    	}
    	if(pre != 0) {
    		sb.append("1");
    	}
    	return sb.reverse().toString();
    	
    }
    
    
}
