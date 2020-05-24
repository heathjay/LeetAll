/**
 * 189. 旋转数组
难度
简单

571





给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
 */
package LeetCode189;


public class Solution {
    public void rotate(int[] nums, int k) {
    	int[] a = new int[nums.length];
    	for(int i = 0 ; i < nums.length; i++) {
    		a[(i+k) % nums.length] = nums[i];
    	}
    	for(int i = 0 ; i < nums.length;i++	) {
    		nums[i] = a[i];
    	}
    }
}
