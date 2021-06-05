package com.leetcode;

/**
 * 给定一个方阵，其中每个单元(像素)非黑即白。设计一个算法，找出 4 条边皆为黑色像素的最大子方阵。
 *
 * 返回一个数组 [r, c, size] ，其中 r, c 分别代表子方阵左上角的行号和列号，size 是子方阵的边长。若有多个满足条件的子方阵，返回 r 最小的，若 r 相同，返回 c 最小的子方阵。若无满足条件的子方阵，返回空数组。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *    [1,0,1],
 *    [0,0,1],
 *    [0,0,1]
 * ]
 * 输出: [1,0,2]
 * 解释: 输入中 0 代表黑色，1 代表白色，标粗的元素即为满足条件的最大子方阵
 * 示例 2:
 *
 * 输入:
 * [
 *    [0,1,1],
 *    [1,0,1],
 *    [1,1,0]
 * ]
 * 输出: [0,0,1]
 * 提示：
 *
 * matrix.length == matrix[0].length <= 200
 *
 * solution:
 * 辅助数组
 * 1, toLeft[i][j] 向左边的最大连续0的个数
 * 2, toUp[i][j] 向上的最大的连接0的个数
 *
 * 然后可以从最底部开始求解：
 * //
 * 如果是顺着我们的思维来，可以从 最上角求解，但是 辅助数组，要是 toRight, toBottom
 *
 */
public class MaxBlackSquareLcci {

    public static int[] findSquare(int[][] m){
        int[] result = new int[3];
        int[][] toLeft = new int[m.length][m[0].length];
        int[][] toUp = new int[m.length][m[0].length];

        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                if(m[i][j]==0) {
                    if (i == 0 && j == 0){
                        toLeft[i][j] = 1;
                        toUp[i][j] = 1;
                    }else if(i==0 && j>0) {
                        toLeft[i][j] = toLeft[i][j-1]+1;
                        toUp[i][j] = 1;
                    }else if(i>0 && j==0) {
                        toUp[i][j] = toLeft[i-1][j]+1;
                        toLeft[i][j] = 1;
                    }else
                    {
                        toLeft[i][j] = toLeft[i][j-1]+1;
                        toUp[i][j] = toUp[i-1][j]+1;
                    }

                }
            }
        }
        for(int i=m.length-1; i>=0; i--){
            for(int j=m[0].length-1; j>=0; j--){
                int maxEdge = Math.min(toLeft[i][j],toUp[i][j]);
                while(maxEdge >0){
                    if(result[2] > maxEdge){break;}
                    //检查正方形的另外两条边
                    //上方
                    int upX = i-maxEdge+1;
                    int upY = j;
                    //左侧
                    int lY= j-maxEdge+1;
                    int lx = i;

                    if(toLeft[upX][upY]>=maxEdge && toUp[lx][lY]>=maxEdge)
                    {	//左侧边  上侧边长都大于等 edge
                        if(maxEdge > result[2])
                        {
                            result[2] = maxEdge;
                            result[0] = upX;
                            result[1] = lY;
                        }
                        else if(maxEdge == result[2] && upX <= result[0])
                        {
                            if(upX < result[0])
                            {
                                result[0] = upX;
                                result[1] = lY;
                            }
                            else if(upX == result[0] && lY < result[1])
                                result[1] = lY;
                        }
                    }
                    maxEdge--;
                }
            }
        }

        return result;
    }


    public static void main(String[]args){
        int[][] m = {
                {1,0,1},
                {0,0,1},
                {0,0,1}
        };

        int[] res= findSquare(m);
        System.out.println(res[0] + " " + res[1] + " " + res[2]);
    }



    }
