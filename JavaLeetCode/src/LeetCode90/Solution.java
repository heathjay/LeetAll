/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode90;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	int k;
	int n;
	List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	this.n = nums.length;
    	
    	for(k =0;k <= n;k++) {
    		backtrack(nums, new ArrayList<Integer>(),0);
    	}
    	return res;
    }
    
    public void backtrack(int[] nums, List<Integer> cur, int start) {
    	if(cur.size() == k) {
    		res.add(new ArrayList<Integer>(cur));
    		return;
    	}
    	
    	for(int i = start; i < n;i++) {
    		if(i>start && nums[i-1] == nums[i]) {
    			continue;
    		}
    		cur.add(nums[i]);
    		backtrack(nums,cur,i+1);
    		cur.remove(cur.size() -1);
    	}
    }
}
