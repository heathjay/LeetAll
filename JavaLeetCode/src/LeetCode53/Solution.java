/**
 * 53. 最大子序和
难度
简单

1967

收藏

分享
切换为英文
关注
反馈
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
package LeetCode53;

class Solution {
	/**
	 * 动态规划
	 * 
	 * @param nums
	 * @return
	 */
    public int maxSubArray(int[] nums) {
    	int pre = 0, max = nums[0];
    	for(int num : nums) {
    		pre = Math.max(num, pre+num);
    		max = Math.max(pre, max);
    	}
    	return max;
    	
    }
}
