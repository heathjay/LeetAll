/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode47;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	int n = nums.length;
    	if(n == 0) return res;
    	ArrayList<Integer> combine = new ArrayList<Integer>();
    	for(int num: nums) {
    		combine.add(num);
    	}
    	
    	backtrack(combine,res,0,n);
    	return res;
    }
    public void backtrack(ArrayList<Integer> com, List<List<Integer>> res, int start, int n) {
    	if(start == n) {
    		res.add(new ArrayList<Integer>(com));
    	}
    	for(int i = start; i < n;i++) {
    		if(i < start && com.get(start)!= com.get(i))  {
    			Collections.swap(com, start, i);
    		}
    		
    		backtrack(com,res,start+1,n);
    		
    		if(i < start && com.get(start) != com.get(i))  {
    			Collections.swap(com, start, i);
    		}
    		
    	}
    }
    public static void main(String[] args) {
    	int[] nums = {1,2,1};
    	System.out.println(new Solution().permuteUnique(nums));
    }
}
