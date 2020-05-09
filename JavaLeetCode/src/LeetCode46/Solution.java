/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
package LeetCode46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	/**
	 * 回溯:
	 * - cur, preout
	 * - 第一次，使用标记map
	 * @param nums
	 * @return
	 */
	 
	static List<List<Integer>> list = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	int len = nums.length;
    	for(int i = 0;i < len; i++) {
    		map.put(i, 0);
    	}
    	List<Integer> pre = new ArrayList<Integer>();
    	process(pre,nums);
    	return list;
    }
    public static void process( List<Integer> pre, int[] nums) {
    	if(pre.size() == nums.length ) {
    		list.add(new ArrayList<Integer>(pre));
    		return ;
    	}
    		for(int j = 0; j < nums.length;j++) {
    			if(pre.contains(nums[j])) continue;
    			pre.add(nums[j]);
    			process(pre,nums);
    			pre.remove(pre.size() -1);
    		}
    		
    }
    /**
     * 不需要额外的监管
     * - 按位来进行交换
     * @param n
     * @param output
     * @param res
     * @param first
     */
    public void backtrack(int n, ArrayList<Integer> output, List<List<Integer>> res, int first) {
    	if(first == n) {
    		res.add(new ArrayList<Integer>(output));
    	}
    	for(int i = first; i < n;i++) {
    		Collections.swap(output, first, i);
    		backtrack(n,output,res,first+1);
    		Collections.swap(output, first, i);
    	}
    }
    public static void main(String[] args) {
    	int[] nums = {1,2,3};
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	System.out.println(permute(nums));
    	//System.out.println(map.get(1));
    	
    }
}