package com.leetcode;

/**
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 *
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 *
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 *
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：cardPoints = [1,2,3,4,5,6,1], k = 3
 * 输出：12
 * 解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
 *
 * ===================
 * 暴力搜索肯定不行的，这里有用到了一些思维，就是通过一个变换，把他变成我们熟悉de问题，我们知道的问题；
 *
 *  这一题就是求中间的元素的最小子集；
 *
 *
 */
public class MaxSumUsingHeadOrTailEle {

    public static int getMax(int[]a,int k){
        int sum =0;
        for(int i=0; i< k;i++){
            sum+=a[i];
        }
        int total = 0;
        for(int i=0; i< a.length;i++){
            total+=a[i];
        }
        int min = sum;
        for(int i=k;i<a.length;i++){
            int cur =sum+a[k]-a[k-i];
            min = Math.min(cur, sum);
            sum =cur;

        }

        return total - min;

    }
}
