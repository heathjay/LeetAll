/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。

你需要按照以下要求，帮助老师给这些孩子分发糖果：

每个孩子至少分配到 1 个糖果。
相邻的孩子中，评分高的孩子必须获得更多的糖果。
那么这样下来，老师至少需要准备多少颗糖果呢？

示例 1:

输入: [1,0,2]
输出: 5
解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
示例 2:

输入: [1,2,2]
输出: 4
解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/candy
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode135;

import java.util.Arrays;

public class Solution {  
	/**
	 * 双数组
	 * @param ratings
	 * @return
	 */
	public int candy(int[] ratings) {
		int sum = 0;
		int[] left2right = new int[ratings.length];
		int[] right2left = new int[ratings.length];
		
		Arrays.fill(left2right, 1);
		Arrays.fill(right2left, 1);
		
		for(int i = 1; i < ratings.length;i++) {
			if(ratings[i] > ratings[i-1]) left2right[i] = left2right[i-1] + 1;
		}
		for(int i = ratings.length - 2; i >= 0; i--) {
			if(ratings[i] > ratings[i+1]) right2left[i] = right2left[i+1]+1;
		}
		for(int i = 0; i <ratings.length;i++) {
			sum += Math.max(left2right[i], right2left[i]);
		}
		return sum;
	}
	public int candy1(int[] ratings) {
		int[] candies = new int[ratings.length];
		Arrays.fill(candies, 1);
		for(int i = 1; i < ratings.length;i++) {
			if(ratings[i] > ratings[i-1]) {
				candies[i] = candies[i-1]+1;
			}
		}
		int sum = candies[ratings.length -1];
		for(int i = ratings.length -2; i>=0; i--) {
			if(ratings[i] > ratings[i+1]) {
				candies[i] = Math.max(candies[i], candies[i+1]);
			}
			sum+=candies[i];
		}
		return sum;
	}
	
	public int count(int  n) {
		return n * (n + 1) / 2;
	}
	public int cc(int[] ratings) {
		if(ratings.length <= 2)
			return ratings.length;
		int candies = 0;
		int up = 0;
		int down = 0;
		int old_slope = 0;
		for(int i = 1; i < ratings.length;i++) {
			int new_slope = (ratings[i] > ratings[i-1] ? 1 : (ratings[i] < ratings[i-1] ? -1 :0));
			if((old_slope > 0 && new_slope == 0) || (old_slope < 0 && new_slope >= 0)) {
				candies += count(up) + count(down) + Math.max(up, down);
				up = 0;
				down = 0;
			}
			if(new_slope > 0) up++;
			if(new_slope < 0) down++;
			if(new_slope == 0) candies++;
			old_slope = new_slope;
		}
		candies += count(up) + count(down) + Math.max(up, down) + 1;
		return candies;
	}
}
