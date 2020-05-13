/*
 * 示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combinations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	List<List<Integer>> output = new LinkedList<>();
	int n;
	int k;
    public List<List<Integer>> combine(int n, int k) {
    	this.k = k;
    	this.n = n;
    	backtrack(1,new LinkedList<Integer>());
    	return output;
    }
    public void backtrack(int first, LinkedList<Integer> curr) {
    	if(curr.size() == k) {
    		output.add(new LinkedList(curr));
    	}
    	
    	for(int i = first; i < n + 1;i++) {
    		curr.add(i);
    		backtrack(i+1,curr);
    		curr.removeLast();
    	}
    }
    
    public List<List<Integer>> com(int n, int k){
    	LinkedList<Integer> nums = new LinkedList<>();
    	for(int i = 1; i < k+1;++i) {
    		nums.add(i);
    	}
    	nums.add(n+1);
    	List<List<Integer>> output = new ArrayList<List<Integer>>();
    	int j = 0;
    	while(j<k) {
    		output.add(new LinkedList(nums.subList(0, k)));
    		j=0;
    		while((j<k) && (nums.get(j+1) == nums.get(j)+1))
    			nums.set(j, j++ + 1);
    		nums.set(j, nums.get(j)+1);
    	}
    	return output;
    }
}
