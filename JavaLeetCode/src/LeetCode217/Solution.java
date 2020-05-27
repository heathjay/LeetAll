/**
 * 给定一个整数数组，判断是否存在重复元素。

如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。

 

示例 1:

输入: [1,2,3,1]
输出: true
示例 2:

输入: [1,2,3,4]
输出: false
示例 3:

输入: [1,1,1,3,3,4,3,2,4,2]
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/contains-duplicate
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	/**
	 * 排序
	 * @param nums
	 * @return
	 */
    public boolean containsDuplicate(int[] nums) {
    	Arrays.sort(nums);
    	for(int i = 0; i < nums.length -1;i++) {
    		if(nums[i] == nums[i+1]) return true;
    	}
    	return false;
    }
    /**
     * hashset
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
    	Set<Integer> set = new HashSet<>();
    	for(int x : nums) {
    		if(set.contains(x))return true;
    		set.add(x);
    	}
    	return false;
    }
}