package com.leetcode;

/**
 *
 * You are given a two-dimensional list of integers matrix. Return the minimum sum you can get by taking a number in each row with the constraint that any row-adjacent numbers cannot be in the same column.
 *
 * Constraints
 *
 * 1 ≤ n ≤ 250 where n is the number of rows in matrix
 * 2 ≤ m ≤ 250 where m is the number of columns in matrix
 * Example 1
 * Input
 * matrix = [
 *     [4, 5, -2],
 *     [2, 6, 1],
 *     [3, 1, 2]
 * ]
 * Output
 * 1
 * Explanation
 * We can take -2 from the first row, 2 from the second row, and 1 from the last row.
 *
 * Example 2
 * Input
 * matrix = [
 *     [3, 0, 3],
 *     [2, 1, 3],
 *     [-2, 3, 0]
 * ]
 * Output
 * 1
 * Explanation
 * We can take 0 from the first row, 3 from the second row, and -2 from the last row.
 *
 *
 * ####
 * d[i][j], 前i行，最后一个是 j 的选择下 最小的路径；
 * d[i+1] = min(d[i][x])+a[i][j], x!=j
 *
 *
 */
public class MinDropPathSum {


    public static int minDropSum(int[][] a){

        int r = a.length, c = a[0].length;
        int[][] d = new int[r][c];

        for(int i=0; i< c; i++) d[0][i] = a[0][i];

        for(int i=1; i< r; i++){
            for(int j=0;j<c;j++){
                int lastMin = Integer.MAX_VALUE;
                for(int k=0; k<c;k++){
                    if(k!=j){
                        lastMin = Math.min(lastMin,d[i-1][k]);
                    }
                }
                d[i][j]=lastMin+a[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i< c; i++){
            min = Math.min(min, d[r-1][i]);
        }

        return min;

    }

    public static void main(String[]args){
        int[][] m = {
                {3, 0, 3},
                {2, 1, 3},
                {-2, 3, 0}
        };

        int res= minDropSum(m);
        System.out.println(res);
    }

}
