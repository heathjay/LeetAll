/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。

要求算法的时间复杂度为 O(n)。

示例:

输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode128;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	/**
	 * 排序
	 * @param nums
	 * @return
	 */
    public int longestConsecutive(int[] nums) {
    	if(nums.length == 0) return 0;
    	Arrays.sort(nums);
    	int longestStreak = 1;
    	int currentStreak = 1;
    	
    	for(int i = 1; i < nums.length;i++) {
    		if(nums[i] != nums[i-1]) {
    			if(nums[i] == nums[i-1] + 1) {
    				currentStreak +=1;
    			}else {
    				longestStreak = Math.max(longestStreak, currentStreak);
    				currentStreak = 1;
    			}
    		}
    	}
    	return Math.max(longestStreak, currentStreak);
    }
    
    public int longestConsecutive1(int[] nums) {
    	Set<Integer> nums_set = new HashSet<>();
    	for(int num: nums) {
    		nums_set.add(num);
    	}
    	
    	int longestStreak = 0;
    	for(int num:nums_set) {
    		if(!nums_set.contains(num-1)) {
    			int currentNum = num;
    			int currentStreak = 1;
    			while(nums_set.contains(currentNum+1)) {
    				currentNum += 1;
    				currentStreak += 1;
    			}
    			longestStreak = Math.max(longestStreak, currentStreak);
    		}
    	}
    	return longestStreak;
    }
}
