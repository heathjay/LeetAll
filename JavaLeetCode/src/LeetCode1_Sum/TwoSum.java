package LeetCode1_Sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
        for(int i = 0 ; i <nums.length;i++) {
        	for(int j = i+1; j <nums.length;j++) {
        		if(nums[i] + nums[j] == target) {
        			result[0] = i;
        			result[1] = j;
        			break;
        		}
        	}
        	
        }
        return result;
    }
	/**
	 * hash表可以用来简化数组的查询遍历
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] hashMap(int[] nums,int target) {
		int[] result = new int[2];
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i<nums.length;i++) {
			map.put(nums[i], i);
		}
		
		for(int i=0; i < nums.length;i++) {
			int remain = target - nums[i];
			if(map.containsKey(remain) && map.get(remain) != i) {
				result[0] = i;
				result[1] = map.get(remain);
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		int[] nums = {3,2,4};
		int target = 6;
		int[] result;
		result = twoSum(nums,target);
		System.out.println(result[1]);
		int[] result1 = hashMap(nums,target);
		System.out.println(result1[0] + " " + result1[1]);
	}
}
