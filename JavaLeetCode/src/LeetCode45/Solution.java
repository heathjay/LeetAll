/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

package LeetCode45;

public class Solution {
	int minS = Integer.MAX_VALUE;
	public int jump(int[] nums) {
		Iter(nums,0,0);
		return minS;
    }
	public void Iter(int[] nums, int start, int jumps) {
		if(start == nums.length-1) {
			minS = Math.min(minS, jumps);
			return;
		}
		if(nums[start] == 0)return;
		for(int i = 1; i <= nums[start] && i+start < nums.length ;i++) {
			if(nums[start+1] == 0)continue;
			Iter(nums,start+i,jumps+1);
		}
	}
	public static void main(String[] args) {
		int[] s = {5,6,4,4,6,9,4,4,0,3,8,5};
		System.out.println(new Solution().jump(s));
	}
	/**
	 * 贪心算法:
	 * - 贪心选择最远的地方,一步到达最后一个位置
	 * @param nums
	 * @return
	 */
	public int jump1(int[] nums) {
		int position = nums.length - 1;
		int steps = 0;
		while(position >0) {
			for(int i = 0; i < position;i++) {
				if(i+nums[i] >= position) {
					position = i;
					steps++;
					break;
				}
			}
		}
		return steps;
	}
	
	/**
	 * 正向贪心算法:
	 * - 贪心选择最远的地方,一步到达最后一个位置
	 * @param nums
	 * @return
	 */
	public int jump2(int[] nums) {
		int len = nums.length;
		int end = 0;
		int maxPosition = 0;
		int steps = 0;
		for(int i = 0; i < len - 1; i++) {
			maxPosition = Math.max(maxPosition, nums[i]+i);
			if(i == end) {
				end = maxPosition;
				steps++;
			}
		}
		return steps;
	}
	
}