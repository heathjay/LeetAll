/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。

示例:

输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
进阶：

一个直观的解决方案是使用计数排序的两趟扫描算法。
首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
你能想出一个仅使用常数空间的一趟扫描算法吗？


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-colors
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode75;

public class Solution {
    public void sortColors(int[] nums) {
    	int cout0 =0;
    	int cout1 = 0;
    	int cout2 = 0;
    	for(int i = 0 ; i < nums.length;i++) {
    		if(nums[i] == 0) {
    			cout0++;
    		}
    		if(nums[i] == 1) {
    			cout1++;
    		}
    		if(nums[i] == 2) {
    			cout2++;
    		}
    	}
    	for(int i = 0;i < nums.length;) {
    		while(cout0 != 0) {
    			cout0--;
    			nums[i]= 0;
    			i++;
    		}
    		while(cout1 != 0) {
    			cout1--;
    			nums[i]= 1;
    			i++;
    		}
    		while(cout2 != 0) {
    			cout2--;
    			nums[i]=2;
    			i++;
    		}
    		
    	}
    }
    public void test1(int[] nums) {
    	int len = nums.length;
    	int p0 = 0;
    	int p2 = len -1 ;
    	int cur = 0;
    	while(cur <= p2) {
    		if(nums[cur] == 0) {
    			int tem = nums[p0];
    			nums[p0] = nums[cur];
    			nums[cur] = tem;
    			p0++;
    		}
    		
    		if(nums[cur]==2) {
    			int temp = nums[p2];
    			nums[p2]= nums[cur];
    			nums[cur]= temp;
    			p2--;
    		}
    		cur++;
    	}
    }
}
