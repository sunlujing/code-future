package com.leetcode;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * ============
 * 常规
 * 两个数组 s[i](0,i 的乘积), e[i]（len, i 的乘积）
 * e[i] 在 算的时候，同时更新 第一个就行，只需要一个数组；
 *
 */
public class ProdOfArrayExcludeSelf {

    public static int[] getProdOfArray(int[] a){
        int [] res= new int[a.length];
        res[0] = 1;
        res[1] = a[0];
        for(int i=2; i< a.length; i++){
            res[i] = a[i-1] * res[i-1];
        }
        int temp = 1;
        for(int j= a.length-1; j>=0;j--){
            res[j] = temp * res[j];
            temp *= a[j];
        }

        return res;
    }

    public static void main(String[]args){
        int[] a = {1,2,3,4};
        a = getProdOfArray(a);
        for(int i=0; i< a.length; i++)
            System.out.print(a[i]+" ");
    }
}
