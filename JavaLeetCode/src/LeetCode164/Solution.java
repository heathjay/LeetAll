/**
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。

如果数组元素个数小于 2，则返回 0。

示例 1:

输入: [3,6,9,1]
输出: 3
解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
示例 2:

输入: [10]
输出: 0
解释: 数组元素个数小于 2，因此返回 0。
说明:

你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-gap
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode164;

import java.util.Arrays;

public class Solution {
	/**
	 * 比较排序
	 * @param nums
	 * @return
	 */
    public int maximumGap(int[] nums) {
    	if(nums.length <2) return 0;
    	Arrays.sort(nums);
    	int res =0;
    	for(int i = 0; i < nums.length - 1;i++) {
    		res = Math.max(res, nums[i+1] - nums[i]);
    	}
    	return res;
    }
    /**
     * 非比较排序
     * @param nums
     * @return
     */
    public int maximumGap1(int[] nums) {
    	if(nums.length < 2) return 0;
    	int max = nums[0], min = nums[0], bias = 0;
    	for(int num : nums) {
    		max =Math.max(max, num);
    		min = Math.min(min, num);
    	}
    	bias = 0-min;
    	int[] counter = new int[max - min + 1];
    	for(int num :nums) counter[num + bias]++;
    	int ans = 0;
    	int pre = -1;
    	for(int i = 0; i < counter.length;i++) {
    		if(counter[i] != 0) {
    			if(pre != -1) {
    				ans = Math.max(ans, i - pre);
    				pre = -i;
    			}else {
    				pre = i;
    			}
    		}
    	}
    	return ans;
    }
    
}
