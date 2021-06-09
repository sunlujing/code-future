package com.leetcode;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 *
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *
 * =========
 * 如何利用有序性
 *
 * 利用最大-最小值的特型； 1-15 = 8， mid；
 * 如果有 2个元素小于 8， 那么，8 还是太小； 8+1， 15， mid = 12;
 * 如果有 多少个元素小于12； 。。
 * 知道 count == k;
 *
 * 是二分排序的一个 变形； 就是视图，对一个数据集合 按照mid 进行划分；
 * 然后不断的找到一个 好的 mid；
 *
 */
public class KthInSortedMatricArray {

    public int findKth(int[][]m, int k){
        int s = m[0][0];
        int e = m[m.length-1][m[0].length-1];

        while(s < e){
            int mid = (s+e)/2;
            int cnt = lessThenMid(m, mid);
            if(cnt < k ) s = s+ 1; else e = mid;
        }
        return s;
    }

    public int lessThenMid(int[][]m, int mid) {
        int curRow = 0;
        // 多少列
        int COL_COUNT = m[0].length;
        // 最后一列的索引
        int LAST_COL = COL_COUNT - 1;
        int res = 0;

        while (curRow < m.length) {
            // 比较最后一列的数据和target的大小
            if (m[curRow][LAST_COL] < mid) {
                res += COL_COUNT;
            }
            else {
                int i = COL_COUNT - 1;
                while (i < COL_COUNT && m[curRow][i] > mid) {
                    i--;
                }
                // 注意这里要加1
                res += i + 1;
            }
            curRow++;
        }
        return res;
    }
}
