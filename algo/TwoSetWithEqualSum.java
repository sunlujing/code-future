package com.leetcode;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * =============
 * 求 找到 子集 = sum/2 = a
 *
 * //第一种，遍历；  比如， pick a[i], 之后，需要 在子数组中， pick, 子问题
 *
 * //第二种， dp 的方法：
 *  从 不可重复选的 物品中 装满 w 的背包：
 *
 *  d[i][w] 标识 选择 i 能够 装满 w 的状态；
 *  d[i+1][w] =d[i][w] || d[i][w-[a[i+1]]];
 *
 *  这是一个双状态的 dp， 也就是 前 i 个， 总和， 类比于 背包问题；
 *  ====
 *  简化： 按照 target 来，如果 target =1;
 *
 *  d[1] 截止到 0; d[2]...0;
 *
 *
 *
 *  ==== 背包问题，求 b[w] 最大；
 *  容量为 1， 有 n 个状态， 截止 到 1-n
 * *  容量为 2， 有 n 个状态， 截止 到 1-n
 */
public class TwoSetWithEqualSum {

    public static boolean findSub(int[]a, int depth,  int target){
        if(target == 0) return true;
        if(depth == a.length && target!=0) return false;

        for(int i=depth; i< a.length ; i++){
            if(findSub(a, i+1,target - a[i])){
                return true;
            }
        }
        return false;
    }

    public static boolean findSubUsingDP(int[]a, int target){
        boolean dp[][] = new boolean[a.length][target+1];
        for (int i = 0; i < a.length; i++) {
            dp[i][0] = true;
        }
        for(int i=0; i<a.length-1;i++){
            for(int j =1; j<=target; j++){
                dp[i + 1][j] =
                        j - a[i] >= 0 ? dp[i][j] || dp[i][j - a[i]] : dp[i][j];
            }
        }
        return dp[a.length - 1][target];
    }




    public static void main(String[] args) {
        int[] n = new int[]{1, 5, 11, 3};
        System.out.println(findSubUsingDP(n,10));
    }
}
