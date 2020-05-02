package LeetCode6_Z;
/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zigzag-conversion
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jay
 *
 */
public class Solution {
	public static String convert(String s, int numRows) {
		int rows = numRows;
		String str = s;
		int step = rows * 2 - 2;
		int len = s.length();
		StringBuilder res = new StringBuilder();
		if(str == null || str.length() == 0) {
			return "";
		}
		if(rows == 1) return str;
		for ( int i = 0 ;i < rows;i++) {
			for(int j = 0; j + i < len; j += step) {
				res.append(str.charAt(i+j));
				if(i != 0 && i != rows -1&& (j+step - i) <len) {
				 res.append(str.charAt(j + step - i));
				}
			}
		}
		return res.toString();
    }
	
	public static String convert1(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

	
	public static void main(String[] args) {
		String s = "LEETCODEISHIRING";
		
		System.out.println(convert(s,3));
		System.out.println(convert1(s,3));
		System.out.println(s);
	}
}
