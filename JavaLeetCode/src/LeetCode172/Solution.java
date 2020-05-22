/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。

示例 1:

输入: 3
输出: 0
解释: 3! = 6, 尾数中没有零。
示例 2:

输入: 5
输出: 1
解释: 5! = 120, 尾数中有 1 个零.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode172;

public class Solution {
    public int trailingZeroes(int n) {
    	int zeroCount = 0;
    	for(int i = 5; i <= n;i+=5) {
    		int currentFactor = 5;
    		while(i % currentFactor == 0) {
    			zeroCount++;
    			currentFactor *= 5;
    		}
    	}
    	return zeroCount;
    }
}
