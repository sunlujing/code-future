package com.leetcode;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 *
 * ======
 * max[i] 包含 i 的最大值
 * min[i] 包含 i 的最小是
 *
 * max[i+1] = max(i, max[i] * max[i-1], max[i]*min[i-1])
 * min[i+1] = max(i, min[i] * min[i-1], max[i]*min[i-1])
 *
 * ans = 记录最大值；
 *
 *
 */
public class MaxPproductSubarray {

    public static int maxProd(int a[]){

        int maxProd = 1, minProd = 1, ans = -10000;
        for (int i=0; i< a.length ; i++) {
            int maxHere = a[i] * maxProd, minHere = a[i] * minProd;
            maxProd = Math.max(maxHere, Math.max(a[i], minHere));
            minProd = Math.min(maxHere, Math.max(a[i], minHere));
            ans = Math.max(ans, maxProd);
        }
        return ans;
    }
}
