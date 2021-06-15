package com.leetcode;

/**
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * 示例 1：
 *
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 *
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 *
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 *
 * ============================
 *
 * 贪心的思维， 正整数， 最大的就是 sum；
 * 如果能够除段就是最后的，如果不行，就减掉一些比较小的数，
 *
 * 32 /3，  见掉， mod %3 = 1, 的两个数，或者mod %3 = 2 的一个数。
 *
 *
 *
 */
public class DivisiableByThree{

    public static int maxDivisable(int[] a){
        int sum = 0;
        for(int i =0; i < a.length ;i++){
            sum +=a[i];
        }
        if(sum% 3 == 0) return sum;
        int mod1_least_1 = Integer.MAX_VALUE, mod1_least_2 =  Integer.MAX_VALUE;
        int mod2_least_1 = Integer.MAX_VALUE;
        for(int i = 0; i< a.length ; i++){
            if(a[i] % 3 ==1 ){
                if(a[i] <= mod1_least_1){
                    mod1_least_2 = mod1_least_1;
                    mod1_least_1 = a[i];
                }
                else if(a[i] <= mod1_least_2 && a[i] > mod1_least_1){
                    mod1_least_2 = a[i];
                }
            }
        }
        for(int i = 0; i< a.length ; i++){
            if(a[i] % 3 ==2 ){
                mod2_least_1 = Math.min(a[i], mod2_least_1);
            }
        }

        return Math.max(sum- mod1_least_1-mod1_least_2, sum-mod2_least_1);
    }

    public static void main(String[]args){
        System.out.println( maxDivisable(new int[]{3,6,5,1,8}));
    }
}
