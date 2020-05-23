/**
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。

骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。

有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。

为了尽快到达公主，骑士决定每次只向右或向下移动一步。

 

编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。

例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。

-2 (K)	-3	3
-5	-10	1
10	30	-5 (P)
 

说明:

骑士的健康点数没有上限。

任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/dungeon-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package LeetCode174;

import java.util.List;

public class Solution {
	
    public int calculateMinimumHP(int[][] dungeon) {
    	if(dungeon == null || dungeon.length == 0|| dungeon[0].length == 0) return 0;
    	int rowLen = dungeon.length;
    	int colLen = dungeon[0].length;
    	return dfs(0,0,rowLen,colLen,dungeon) + 1;
    }
    public int dfs(int rowIndex, int colIndex, int rowSize, int colSize, int[][] dungeon) {
    	if(rowIndex >= rowSize || colIndex >= colSize) return Integer.MAX_VALUE;
    	
    	if(rowIndex == rowSize - 1 && colIndex == colSize -1) {
    		if(dungeon[rowIndex][colIndex] >= 0	) return 0;
    		else return -dungeon[rowIndex][colIndex];
    	}
    	int rightMin = dfs(rowIndex,colIndex+1,rowSize,colSize,dungeon);
    	int downMin = dfs(rowIndex+1,colIndex,rowSize,colSize,dungeon);
    	int res = 0;
    	int needMin = Math.min(rightMin, downMin) - dungeon[rowIndex][colIndex];
    	if(needMin < 0) res = 0;
    	else res = needMin;
    	return res;
    }
    /**
     * 动态规划
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP1(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int rowSize = dungeon.length;
        int colSize = dungeon[0].length;
        int[][] dp = new int[rowSize][colSize];
        // 设置最后一个值。
      	dp[rowSize - 1][colSize -1] = Math.max(0, -dungeon[rowSize - 1][colSize - 1]);

        // 设置最后一列的值
      	for (int i = rowSize - 2; i >= 0; --i) {
            int needMin = dp[i + 1][colSize - 1] - dungeon[i][colSize - 1];
            dp[i][colSize -1] = Math.max(0, needMin);
        }

        // 设置最后一行的值
      	for (int i = colSize - 2; i >= 0; --i) {
            int needMin = dp[rowSize - 1][i + 1] - dungeon[rowSize - 1][i];
            dp[rowSize - 1][i] = Math.max(0, needMin);
        }

        for (int i = rowSize - 2; i >= 0; --i) {
            for (int j = colSize - 2; j >= 0; --j) {
    			// 从右边和下边选择一个最小值，然后减去当前的 dungeon 值
                int needMin = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = Math.max(0, needMin);
            }
        }
        return dp[0][0] + 1;

    }
    
}
