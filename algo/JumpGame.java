package com.leetcode;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * #####
 * 两种思路，一个是从左 往右，看看达到的最大 坐标；
 * 一个是从 右往左， 看看，需要的最大的gap；
 *
 */
public class JumpGame {
    public static boolean canReach(int[] a){
        int maxReach = 0;

        for(int i=0; i< a.length - 1; i++){
            maxReach = Math.max(i+a[i],maxReach);
        }
        return maxReach >=a.length-1;
    }

    public static boolean canReachV2(int[]a){
        int maxGap = 0;
        for(int i=a.length - 2; i>=0; i--){
            if(a[i] <maxGap+1){maxGap = a.length-1-i;}
            else maxGap = 0;
        }
        return maxGap <=0;
    }

    public static void main(String[] args) {
        int[] n = new int[]{3,2,1,0,4};
        System.out.println(canReach(n));
        System.out.println(canReachV2(n));

        n = new int[]{2,3,1,1,4};
        System.out.println(canReach(n));
        System.out.println(canReachV2(n));



    }
}

