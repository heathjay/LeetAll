/**
 * 179. 最大数




给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

示例 1:

输入: [10,2]
输出: 210
示例 2:

输入: [3,30,34,5,9]
输出: 9534330
说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
package LeetCode179;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] nums) {
    	String[] asStrs = new String[nums.length];
    	for(int i =0 ; i < nums.length;i++) {
    		asStrs[i] = String.valueOf(nums[i]);
    	}
    	Arrays.sort(asStrs, new LargeNumberComp());
    	if(asStrs[0].equals("0")) return "0";
    	String largest = new String();
    	for(String numAs : asStrs) {
    		largest += numAs;
    	}
    	return largest;
    }
    private class LargeNumberComp implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			String order1 = o1 + o2;
			String order2 = o2 + o1;
			return order2.compareTo(order1);
		}
    	
    }
}
