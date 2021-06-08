package com.leetcode;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 *
 *
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,7]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 *
 * 进阶：
 *
 * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * ===================
 *
 * 连续子数组的问题，使用 滑动窗口，就是两个指针，不断的向前滑动；
 */
public class SubArrayWithSum {


    public static int minSubArray(int[] a, int sum){
        int s=0;
        int e=0;
        int min = a.length;
        int total =0;
        while(e< a.length){

            total =total + a[e];
            if(total < sum) e++;
            else{
                min = Math.min(min, e-s+1);
                if(e>s){

                    total = total-a[s]-a[e];
                    s++;
                }
            }
        }
        return min;
    }

    public static int minSubArrayEqualSum(int[] a, int sum){
        int s=0;
        int min = Integer.MAX_VALUE;
        int total =0;
        for(int i=0; i< a.length ; i++){
            total = total + a[i];

            while(total >= sum){
                if(total == sum){
                    min = Math.min(min, i-s+1);
                }
                total = total - a[s];
                s++;
            }

        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[]args){
        System.out.println(minSubArray(new int[]{11,3,1,2,4,7},7));
        System.out.println(minSubArrayEqualSum(new int[]{11,3,1,2,4,7},6));
        System.out.println(minSubArrayEqualSum(new int[]{11,3,1,2,4,7},4));

    }

}
