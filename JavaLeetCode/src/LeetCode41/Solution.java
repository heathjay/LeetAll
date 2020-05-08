/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。

 

示例 1:

输入: [1,2,0]
输出: 3
示例 2:

输入: [3,4,-1,1]
输出: 2
示例 3:

输入: [7,8,9,11,12]
输出: 1


 */
package LeetCode41;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	/**
	 * 配合索引进行
	 * - 负数为1
	 * - 超出n为1
	 * - 索引对应有的nums【i】
	 * @param nums
	 * @return
	 */
	 public int firstMissingPositive(int[] nums) {
		 int n = nums.length;
		 
		 int contains = 0;
		 for(int i = 0; i <n;i++) {
			 if(nums[i] == 1) {
				 contains++;
				 break;
			 }
		 }
		 
		 if(contains == 0) {
			 return 1;
		 }
		 if(n ==1 ) return 2;
		 for(int i = 0 ; i < n ; i++) {
			 if((nums[i] <= 0|| nums[i] > n)) nums[i] =1;
		 }
		 
		 for(int i = 0; i < n; i++) {
			 int a = Math.abs(nums[i]);
			 if(a==n) {
				 nums[0] = -Math.abs(nums[0]);
			 }else {
				 nums[a] = - Math.abs(nums[a]);
			 }
		 }
		 
		 for(int i = 1;i < n ; i++) {
			 if(nums[i] > 0) {
				 return i;
			 }
		 }
		 if(nums[0] > 0) {
			 return n;
		 }
		 return n+1;
	  }
	 
	 public int test(int[] nums) {
		 if(nums.length ==0) return 1;
		 Map<Integer,Integer> map = new HashMap<>();
		 
		 for(int i = 0;i < nums.length;i++) {
			 map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		 }
		 int i = 1;
		 while(true) {
			 if(!map.containsKey(i)) return i;
			 i++;
		 }
	 }
}
