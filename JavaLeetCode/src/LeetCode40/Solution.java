/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
   		 	Arrays.sort(candidates);
   		 	List<Integer> combination = new ArrayList<Integer>();
   		 	Iterator(0,combination,candidates,target);
   		 	return list;
   	    }
   	 public void Iterator(int start,List<Integer> com, int[] cand, int tar ) {
   		 if(tar < 0) {
   			 return;
   		 }
   		 if(tar == 0) {
   			 list.add(new ArrayList<>(com));
   		 }else {
   			 for(int i = start ; i< cand.length;i++) {
   				 if(i > start && cand[i] == cand[i-1]) continue;
   				 com.add(cand[i]);
   				 Iterator(i+1,com, cand,tar-cand[i]);
   				 com.remove(com.size() - 1);
   			 }
   		 }
   	 }
    
}
