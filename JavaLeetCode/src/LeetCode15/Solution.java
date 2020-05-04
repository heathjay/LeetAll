package LeetCode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jay
 *
 */
public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res= new ArrayList<List<Integer>>();
		if(nums.length<3) return res;
		Arrays.sort(nums);
		int len = nums.length;
		for(int i = 0; i < nums.length;i++) {
			if(nums[i] > 0) return res;
			if(i>0&&nums[i] == nums[i-1]) continue;
			int L = i+1;
			int R = len -1;
			while(L < R) {
				int sum = nums[i] + nums[L] + nums[R];
				if(sum == 0) {
					List<Integer> list = new ArrayList<Integer>();
					/*
					list.add(nums[i]);
					list.add(nums[L]);
					list.add(nums[R]);
					res.add(list);*/
					res.add(Arrays.asList(nums[i],nums[L],nums[R]));
					
					while(L < R && nums[L] == nums[L+1]) L++;
					while(L < R && nums[R] == nums[R-1]) R--;
					L++;
					R--;
				}else if(sum>0) {
					R--;
				}else if (sum < 0) {
					L++;
				}
			}
		}
		return res;
    }
}
