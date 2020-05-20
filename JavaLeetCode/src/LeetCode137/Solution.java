/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,3,2]
输出: 3
示例 2:

输入: [0,1,0,1,0,1,99]
输出: 99

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/single-number-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode137;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int singleNumber(int[] nums) {
    	Set<Long> set = new HashSet<>();
    	long sumSet = 0, sumArray = 0;
    	for(int n : nums) {
    		sumArray += n;
    		set.add((long) n );
    	}
    	for(Long s : set) sumSet += s;
    	return (int) ((3 * sumSet - sumArray) / 2);
    }
    
    public int singleNum(int[] nums) {
    	int seenOnce = 0 , seenTwice = 0;
    	for(int num : nums) {
    		seenOnce = - seenTwice & (seenOnce ^ num);
    		seenTwice = - seenOnce & (seenTwice ^ num);
    	}
    	return seenOnce;
    }
}
