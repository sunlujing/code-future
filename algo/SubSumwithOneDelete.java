package com.alipay.sofa.jraft.test.atomic.leetcode;

/**
 * 给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。
 *
 * 换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。
 *
 * 注意，删除一个元素后，子数组 不能为空。
 *
 * 请看示例：
 *
 * 示例 1：
 *
 * 输入：arr = [1,-2,0,3]
 * 输出：4
 * 解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。
 * 示例 2：
 *
 * 输入：arr = [1,-2,-2,3]
 * 输出：3
 * 解释：我们直接选出 [3]，这就是最大和。
 * 示例 3：
 *
 * ====
 * 这道题目，要用到 ，连续子序列的最大和。 需要 a[i] 以 i 结尾的最大和；
 *
 */

public class SubSumwithOneDelete {

    /**
     * 前缀和+ 后缀和等数组，对于 删除元素的题目很有用
     * @return
     */
    public static int getSubSumWithDelete(int[] a){
        int [] l = new int[a.length];
        int [] r = new int[a.length];
        int res = a[0];
        for(int i=1; i< a.length; i++){
            l[i] = Math.max(a[i], l[i-1]+a[i]);
            res = Math.max(res, l[i]);
        }
        for(int i=a.length-1; i>=0; i--){
            r[i] = Math.max(a[i], r[i+1]+a[i]);
            res = Math.max(res, r[i]);

        }
        for(int i=1; i< a.length-1;i++){
            res = Math.max(res, l[i - 1] + r[i + 1]);
        }
        //删除的情况

        return res;

    }

    //设 d【i】 不删除 元素，以 i 结尾最大值； di = max(d-i1+ ai, ai)
    //设 m[i] 为 以 i， 或者i+1， 为结尾 的最大， i 结尾时，  mi = mi-1+a[i], i-1 为结尾， di-1.

    public static int usingDP(int[] a){
        return 0;
    }

}
