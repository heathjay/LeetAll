/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode215;

import java.util.PriorityQueue;
import java.util.Random;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
    	PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2) -> n1-n2);
    	for(int n : nums) {
    		heap.add(n);
    		if(heap.size() > k) heap.poll();
    	}
    	return heap.poll();
    }
    /**
     * 快速选择
     * @param nums
     * @param k
     * @return
     */
    int[] nums;
    public void swap(int a, int b) {
    	int tmp = a;
    	a = b;
    	b = a;
    }
    public int partition(int left,int right, int pivot_index) {
    	int pivot = this.nums[pivot_index];
    	swap(pivot_index, right);
    	int store_index = left;
    	
    	for(int i = left; i <= right;i++) {
    		if(this.nums[i] < pivot) {
    			swap(store_index, i);
    			store_index++;
    		}
    	}
    	swap(store_index, right);
    	return store_index;
    }
    public int quickselect(int left, int right,int k_smallest) {
    	if(left == right) return this.nums[left];
    	Random random_num = new Random();
    	int pivot_index = left + random_num.nextInt(right - left);
    	pivot_index = partition(left, right, pivot_index);
    	if(k_smallest == pivot_index) return this.nums[k_smallest];
    	else if (k_smallest < pivot_index) return quickselect(left, pivot_index - 1, k_smallest);
    	return quickselect(pivot_index + 1, right, k_smallest);
    }
    public int findKthLargest1(int[] nums, int k) {
    	this.nums = nums;
    	int size = nums.length;
    	return quickselect(0, size - 1, size - k);
    }
}
