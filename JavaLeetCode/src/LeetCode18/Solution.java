/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/4sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums.length<4) return res;
		Arrays.sort(nums);
		int len = nums.length;
		for(int i = 0; i <= len-4;i++) {
			if(nums[i] > target) break;
			int next = i + 1;
			if(i>0 && nums[i] == nums[i-1]) continue;
			while(next <= len - 3) {
				if(next > (i+1) && nums[next -1] == nums[next]) continue;
				int L = next + 1;
				int R = len-1;
				while(L< R) {
					int sum = nums[i] + nums[next] + nums[L]+ nums[R];
					 if(sum>target) {
						R--;
					}else if(sum < target) {
						L++;
					}else {
							res.add(Arrays.asList(nums[i],nums[next],nums[L],nums[R]));
							while(L<R && nums[L] == nums[L+1])L++;
							while(L < R && nums[R] == nums[R-1])R--;
							L++;
							R--;
					}
				}
				
				next ++;
			}
		}
		
		return res;
    }
}
