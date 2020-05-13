/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
    	int len = nums.length;
    	if(len == 0) return res;
    	res.add(new ArrayList<Integer>());
    	for(int i=1;i < len ; i++) {
    		start(i,nums);
    	}
    	List<Integer> last = new LinkedList<>();
    	for(int i = 0; i < len;i++) {
    		last.add(nums[i]);
    	}
    	res.add(last);
    	return res;
    }
    public void start(int l, int[] nums) {
    	backtrack(0,l,nums, new LinkedList<Integer>());
    }
    public void backtrack(int first,int k, int[] nums, LinkedList<Integer> cur) {
    	if(cur.size() == k) {
    		res.add(new LinkedList<Integer>(cur));
    	}
    	
    	for(int i = first; i < nums.length;i++	) {
    		cur.add(nums[i]);
    		backtrack(i+1,k,nums,cur);
    		cur.removeLast();
    	}
    }
    
    /**
     * 递归
     */
    public List<List<Integer>> test1(int[] nums){
    	List<List<Integer>> output = new ArrayList();
    	output.add(new ArrayList<Integer>());
    	for(int num : nums) {
    		List<List<Integer>> newSubsets = new ArrayList<>();
    		for(List<Integer> cur : output) {
    			newSubsets.add(new ArrayList<Integer> (cur) {{add(num);}})	;
    		}
    		for(List<Integer> curr: newSubsets) {
    			output.add(curr);
    		}
    	}
    	return output;
    }
    /**
     * 回溯
     */
    int n,k;
    List<List<Integer>> resout = new ArrayList<>();
    public List<List<Integer>> subset(int[] nums){
    	n = nums.length;
    	for(k=0;k<n+1;k++) {
    		ba(0,new ArrayList<Integer>(),nums);	
    	}
    	return resout;
    }
    
    public void ba(int first,List<Integer> cur, int[] nums) {
    	if(cur.size() == k) {
    		resout.add(new ArrayList<>(cur));
    	}
    	for(int i = first; i < nums.length;i++	) {
    		cur.add(nums[i]);
    		ba(i+1,cur,nums);
    		cur.remove(cur.size() -1 );
    	}
    }
}
