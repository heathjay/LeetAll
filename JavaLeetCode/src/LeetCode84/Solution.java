/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。
以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
示例:
输入: [2,1,5,6,2,3]
输出: 10
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode84;

import java.util.Stack;

public class Solution {
	/**
	 * 暴力法
	 * @param heights
	 * @return
	 */
    public int largestRectangleArea(int[] heights) {
    	int maxarea = 0 ;
    	for(int i = 0 ; i < heights.length;i++) {
    		for(int j = i; j < heights.length;j++) {
    			int minheight = Integer.MAX_VALUE;
    			for(int k = i; k <= j; k++) {
    				minheight = Math.min(minheight, heights[k]);
    			}
    			maxarea = Math.max(maxarea, minheight) * (j-i+1);
    		}
    	}
    	return maxarea;
    }
    public int up(int[] heights) {
    	int maxarea = 0;
    	for(int i = 0; i < heights.length;i++) {
    		int minheight = Integer.MAX_VALUE;
    		for(int j = i; j < heights.length;j++) {
    			minheight = Math.min(minheight, heights[j]);
    			maxarea = Math.max(maxarea, minheight*(j-i+1));
    		}
    	}
    	return maxarea;
    }
    /**
     * 分治
     */
    public int testf(int[] heights) {
    	return cal(heights, 0 , heights.length -1);
    }
    public int cal(int[] heights, int start, int end) {
    	if(start > end) {
    		return 0;
    	}
    	
    	int minindex = start;
    	for(int i = start; i <= end;i++	) {
    		if(heights[minindex] > heights[i]) minindex = i;
    	}
    	return Math.max(heights[minindex] * (end - start +1), Math.max(cal(heights, start, minindex -1 ), cal(heights, minindex + 1, end)));
    }
    
    /**
     * 栈
     */
    public int lar(int[] height) {
    	Stack<Integer> stack = new Stack<>();
    	stack.push(-1);
    	int maxarea	= 0;
    	for(int i = 0; i < height.length;i++) {
    		while(stack.peek() != -1 && height[stack.peek()] >= height[i]) {
    			maxarea = Math.max(maxarea, height[stack.pop()] * (i - stack.peek() -1));
    		}
    		stack.push(i);
    	}
    	while(stack.peek() != -1) {
    		maxarea = Math.max(maxarea, height[stack.pop()] * (height.length - stack.peek() - 1));
    	}
    	return maxarea;
    }
}
