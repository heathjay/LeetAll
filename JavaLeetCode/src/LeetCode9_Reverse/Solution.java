package LeetCode9_Reverse;
/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
进阶:

你能不将整数转为字符串来解决这个问题吗？


 * @author jay
 *
 */
public class Solution {
	  public static  boolean isPalindrome(int x) {
		  if(x < 0) return false;
		  String s = x + "";
		  
		  String reverse = (new StringBuffer(s)).reverse().toString();
		  
		  
		  return s.equals(reverse);
	    }
	  public static  boolean isPalindrome2(int x) {
		  if(x < 0 || x > Integer.MAX_VALUE) return false;
		  int rev= 0;
		  int t = x;
		  while(x!=0) {
			  int pop = x % 10;
			  rev = rev * 10 + pop;
			  x = x / 10;
		  }
		  System.out.println(rev);
		  return t==rev;
		  
	    }
	  public static void main(String[] args) {
		  int a = 90;
		  String str = a +"";
		  System.out.println( isPalindrome2(121));
	  }
}
