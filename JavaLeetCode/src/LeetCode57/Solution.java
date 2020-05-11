/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。

在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

示例 1:

输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
输出: [[1,5],[6,9]]
示例 2:

输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出: [[1,2],[3,10],[12,16]]
解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。

 */
package LeetCode57;

import java.util.LinkedList;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
    	int newStart = newInterval[0], newEnd = newInterval[1];
    	int idx = 0, n = intervals.length;
    	LinkedList<int[]> output = new LinkedList<int[]>();
    	
    	while(idx < n && newStart > intervals[idx][0]) output.add(intervals[idx++]);
    	int[] interval = new int[2];
    	if(output.isEmpty() || output.getLast()[1] < newStart) {
    		output.add(newInterval);
    	}else {
    		interval = output.removeLast();
    		interval[1] = Math.max(interval[1], newEnd);
    		output.add(interval);
    	}
    	
    	while(idx < n) {
    		interval = intervals[idx++];
    		int start = interval[0], end = interval[1];
    		if(output.getLast()[1] < start) output.add(interval);
    		else {
    			interval = output.removeLast();
    			interval[1] = Math.max(interval[1], end);
    			output.add(interval);	
    		}
    	}
    	return output.toArray(new int[output.size()][2]);
    }
}
