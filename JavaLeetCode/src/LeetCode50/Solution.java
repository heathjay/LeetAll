/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25

 */
package LeetCode50;

public class Solution {
	/**
	 * 快速幂乘积
	 * @param x
	 * @param n
	 * @return
	 */
	public double quickMul(double x, long N) {
		if (N == 0) return 1.0;
		double y = quickMul(x, N/2);
		return N % 2 == 0 ? y * y :y*y*x;
	}
	public double myPow(double x, int n) {
		long N = n;
		return N >= 0? quickMul(x,N) : 1.0 / quickMul(x,-N);
    }
}
