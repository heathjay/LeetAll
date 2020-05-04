package LeetCode11;
/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jay
 *
 */
public class Solution {
	public static int maxArea(int[] height) {
		int maxA = 0;
		for(int i = 0; i < height.length; i ++) {
			for(int j = i + 1; j < height.length; j ++) {
				int tem =(j - i) * Math.min(height[i], height[j]);
				if(tem > maxA) maxA = tem;
			}
		}
			
		return maxA;
    }
	/**
	 * 双指针法
	 * - 短端向内
	 * @param height
	 * @return
	 */
	public static int maxArea2(int[] height) {
		int maxArea = 0;
		int head = 0;
		int tail = height.length - 1;
		while(head < tail) {
			int tem = Math.min(height[head],height[tail]) * (tail - head);
			maxArea = Math.max(tem, maxArea);
			if(height[head] < height[tail]) {
				head ++;
			}else {
				tail --;
			}
		}
		return maxArea;
	}
	public static void main(String[] args) {
		int[] a = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea2(a));
	}

}
