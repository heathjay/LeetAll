/**
 * 209. 长度最小的子数组
给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
package LeetCode209;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    	int len = nums.length;
    	int minLen  = len+1;
    	for(int i = 0 ; i < len;i++) {
    		int sum = 0;
    		for(int j = i; j < len; j++) {
    			sum+= nums[j];
    			if(sum >= s) {
    				minLen = Math.min(minLen, j-i+1);
    				break;
    			}
    		}
    	}
    	return minLen==(len+1)?0:minLen;
    }
    
    public int minSubArrayLen1(int s, int[] nums) {
    	int n = nums.length;
    	if(n==0)return 0;
    	int left=0,right=0;
    	int minlen=0;
    	int sum_left_to_right = 0;
    	while(right < n) {
    		sum_left_to_right += nums[right];
    		if(sum_left_to_right >=s) {
    			if(minlen == 0) minlen = right -left+1;
    			else minlen = Math.min(minlen, right-left+1	);
    			sum_left_to_right -= nums[left];
    			sum_left_to_right -= nums[right];
    			left+=1;
    		}else {
    			right+=1;
    		}
    		if(left>right) return 1 ;
    	}
    	return minlen;
    }
}
