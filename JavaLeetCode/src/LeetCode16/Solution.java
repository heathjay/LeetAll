package LeetCode16;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum-closest
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jay
 *
 */
public class Solution {
	/**
	 * 指针双排序
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumClosest(int[] nums, int target) {
		if(nums.length < 3) return 0;
		Arrays.sort(nums);
		
		int res = nums[0] + nums[1] + nums[2];
		int len = nums.length;
		for(int i = 0; i < len; i++) {
			if(i > 0 &&nums[i] == nums[i-1]) continue;
			int L = i + 1;
			int R = len-1;
			while(L < R) {
				int sum = nums[i]+nums[L]+nums[R];
				if(Math.abs(target - sum) <Math.abs(target - res)) {
					res = sum;
				}else if (target > sum) {
					L++;
				}else if(target < sum) {
					R--;
				}else {
					return res;
				}
			}
		}
		return res;
    }
}
