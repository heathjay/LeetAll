/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/trapping-rain-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode42;

public class Solution {
	/**
	 * 双指针,每个位置上方部分有多少水
	 * @param height
	 * @return
	 */
	public int trap(int[] height) {
		int res = 0;
		int n = height.length;
		
		for(int i = 1; i < n; i++) {
			int max_left = 0, max_right = 0;
			for(int j = i; j >= 0 ; j--) {
				max_left = Math.max(max_left, height[j]);
			}
			for(int j = i;j<n;j++) {
				max_right = Math.max(max_right, height[j]);
			}
			
			res += Math.min(max_left, max_right) - height[i];
		}
		return res;
	  }
	/**
	 * 动态编程,
	 * 用数组去记录每一个左边最大和右边最大
	 * @param height
	 * @return
	 */
	public int test2(int[] height) {
		int res = 0;
		if(height == null || height.length == 0	) return 0;
		
		int len = height.length;
		int[] left = new int[len];
		int[] right = new int[len];
		left[0] = height[0];
		right[len-1] = height[len-1];
		
		
		for(int i = 1; i < len; i++) {
			left[i] = Math.max(height[i], left[i-1]);
		}
		
		for(int i = len-2;i>=0;i--) {
			right[i] = Math.max(height[i], right[i+1]);
		}
		//这里注意
		for(int i = 1; i < len -1; i++) {
			res += Math.min(left[i], right[i]) - height[i];
		}
		return res;
	}
	/**
	 * 双指针
	 * @param height
	 * @return
	 */
	public int test3(int[] height) {
		int left = 0, right = height.length - 1;
		int res = 0;
		int left_max = 0, right_max = 0;
		while(left < right) {
			if(height[left] < height[right]) {
				if(height[left] >= left_max) {
					left_max = height[left];
					
				}else {
					res += left_max - height[left];
				}
				left++;
			}else {
				if(height[right] >= right_max) {
					right_max = height[right];
					
				}else {
					res += right_max - height[right];
				}
				right--;
			}
		}
		return res;
	}
}
