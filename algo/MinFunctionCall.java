package com.leetcode;

/**
 * 给你一个与 nums 大小相同且初始值全为 0 的数组 arr ，请你调用以上函数得到整数数组 nums 。
 *
 * 请你返回将 arr 变成 nums 的最少函数调用次数。
 *
 * option-1, 对i 元素 + 1；
 * option-2, 对 所有元素 * 2;
 *
 * 示例 1：
 *
 * 输入：nums = [1,5]
 * 输出：5
 * 解释：给第二个数加 1 ：[0, 0] 变成 [0, 1] （1 次操作）。
 * 将所有数字乘以 2 ：[0, 1] -> [0, 2] -> [0, 4] （2 次操作）。
 * 给两个数字都加 1 ：[0, 4] -> [1, 4] -> [1, 5] （2 次操作）。
 * 总操作次数为：1 + 2 + 2 = 5 。
 * 示例 2：
 *
 * ======
 *
 * 问题转化，对于给定数组， 经过一顿操作，变为 0，0
 *
 */
public class MinFunctionCall {

    public static int getMinFunctionCall(int[] a){
        int maxMuiptl = 0;
        int add =0;
        for(int i=0; i< a.length ;i++){
            int multInOneRound = 0;
            while(a[i] > 0){
                if(a[i]%2==1){
                    add ++;
                    a[i] = a[i]-1;
                }
                if (a[i] >= 2){
                    multInOneRound++;
                    a[i] /=2;
                }
            }
            
            maxMuiptl = Math.max(multInOneRound,maxMuiptl);
        }
        return maxMuiptl+add;
    }
}
