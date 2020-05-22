/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	private Map<Integer,Integer> countNums(int[] nums){
		Map<Integer,Integer> counts = new HashMap<Integer,Integer>();
		for(int num : nums) {
			if(!counts.containsKey(num)) {
				counts.put(num, 1);
			}else {
				counts.put(num, counts.get(num)+1);
			}
		}
		return counts;
	}
    public int majorityElement(int[] nums) {
    	Map<Integer,Integer> counts = countNums(nums);
    	Map.Entry<Integer, Integer> majorityEntity = null;
    	for(Map.Entry<Integer, Integer> entry: counts.entrySet()) {
    		if(entry == null || entry.getValue() > majorityEntity.getValue()) majorityEntity = entry;
    	}
    	return majorityEntity.getKey();
    }
    /**
     * 排序
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
    	Arrays.sort(nums);
    	return nums[nums.length/2];
    }
}
