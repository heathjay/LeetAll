/**
 * 给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。


 */
package LeetCode56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Solution {
	   public int[][] merge(int[][] intervals) {
		   int len = intervals.length;
		   int[][] res = new int[len][2];
		  if(intervals.length == 0) return res;
		 /* 
		  Arrays.sort(intervals, new Comparator<int[]>(){

			@Override
			public int compare(int[] a, int[] b) {
				if(a[0] == b[0]) {
					return a[1] - b[1];
				}else {
					return a[0] - b[0];
				}
			}
			  
		  });
		  */
		  
		  Arrays.sort(intervals,(v1,v2) -> v1[0] - v2[0]);
		  int idx = -1;
		  for(int[] num : intervals) {
			  if(idx == -1 || num[0] > res[idx][1]) {
				  res[++idx] = num;
			  }else {
				  res[idx][1] = Math.max(res[idx][1], num[1]);
			  }
		  }
		  return Arrays.copyOf(res, idx +1);
	   }
	   
	   public static void main(String[] args) {
		   int[][] mm = new int[][] {{1,3},{2,6},{8,10},{15,18}};
		   System.out.println(new Solution().merge(mm));
	   }
}
