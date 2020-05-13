/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。

编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

示例 1:

输入: nums = [2,5,6,0,0,1,2], target = 0
输出: true
示例 2:

输入: nums = [2,5,6,0,0,1,2], target = 3
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode81;

public class Solution {
    public boolean search(int[] nums, int target) {
    	if(nums == null || nums.length == 0) {
    		return false;
    	}
    	int start = 0;
    	int end = nums.length - 1;
    	int mid;
    	while(start <= end) {
    		mid = start + (end - start) / 2;
    		if(nums[mid] == target) {
    			return true;
    		}
    		if(nums[start] == nums[mid]) {
    			start++;
    			continue;
    		}
    		
    		if(nums[start] < nums[mid]) {
    			if(nums[mid] > target && nums[start] <= target) {
    				end =mid-1;
    			}else {
    				start = mid+1;
    			}
    		}else {
    			if(nums[mid] < target && nums[end] >= target) {
    				start = mid +1;
    			}else {
    				end = mid-1;
    			}
    		}
    	}
    	return false;
    }
}
