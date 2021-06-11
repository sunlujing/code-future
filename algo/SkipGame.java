package com.leetcode;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置，数组中的每个元素代表你在该位置可以跳跃的最大长度，
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 示例:
 * 输入: [2, 3, 1, 1, 4]
 * 输出: 2
 * 思路； 记录 1 步 最远跳到哪里；
 *        2 步最远调到哪里；
 *        N 步最远；
 *
 *  或者记录preMax；
 *
 *  在premax 里面的都可以；
 *
 */
public class SkipGame {

    public static boolean canBeReach(int[] a){
        int preMax = a[0];
        int max = preMax;

        for(int i=1; i< a.length-1; i++){
            if(i <= preMax){
                //can skip

                max =Math.max(preMax, a[i]+i);
            }
            if(max >=a.length-1 ) return true;

            if(i == preMax) preMax = max;

        }
        return false;
    }

    public static int canReachUsingMinStep(int[] a){
        int preMax = a[0];
        int max = preMax;
        int step = 1;

        for(int i=1; i< a.length-1; i++){
            if(i <= preMax){
                //can skip
                max =Math.max(preMax, a[i]+i);
            }
            if(max >=a.length ) return step+1;

            if(i == preMax) { preMax = max; step++;}
            if(i > preMax)  {
                step =  Integer.MAX_VALUE;
                break;
            }

        }
        return step;
    }

    public static void main(String[]args){
        System.out.println(canBeReach(new int[]{2, 3, 1, 1, 1,1,8}));

        System.out.println(canReachUsingMinStep(new int[]{2, 3, 1, 1, 1,1,8}));
    }

}
