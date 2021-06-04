package com.leetcode;

/**
 * 打家劫舍的题目，泛化：
 * [[1, 3, 5, 4, 9]]
 * 1+5+9, 不能使用相邻的元素，构建最大的和
 */
public class MaxProfitStealing {


    /**
     * m[i] 包含i 的最大， n[i] 为不包含 i 元素的最大。
     *
     * m[i+1]= n[i] + a[i]
     * n[i+1]=max(m[i], n[i])
     *
     *
     * @param a
     * @return
     */

    public static int getMaxSumWithNeighour(int [] a){

        int[] m = new int[a.length];
        int[] n = new int[a.length];

        m[0] = a[0];
        n[0] = 0;
        m[1] = a[1];
        n[1] = m[0];

        for(int i=2; i< a.length ; i++){
            m[i] = n[i-1]+ a[i];
            n[i] = Math.max(m[i-1], n[i-1]);
        }

        return Math.max(m[a.length-1], n[a.length-1]);

    }

    /**
     * 使用一个数组：
     * m[i] 为包含 i 个元素的 最大值
     *
     * m[i+1] = m[i-2]+ a[i]
     *        = m[i-3] + a[i],
     *
     * 最多隔开两个，因为 隔开三个，中间的必然可以构建一个更大值。
     *
     *
     *
     * @param a
     * @return
     */
    public static int getMaxMethod2(int [] a){
        int[] m = new int[a.length];

        m[0] = a[0];
        m[1] = a[1];
        m[2] = Math.max(a[1], a[0]+ a[2]);

        for(int i=3; i< a.length ; i++){
            m[i] = Math.max(m[i-2]+a[i], m[i-3]+a[i]);
        }

        return Math.max(m[a.length-1], m[a.length-2]);
    }

    /**
     * 最优化，数组可以使用 3个变量代替，只有 相邻的三个子 问题有关，与 弗波纳契的解法相似
     * @param a
     * @return
     */
    public static int bestMethod(int [] a){

        int m1 = a[0];
        int m2 = a[1];
        int m3 = Math.max(a[1], a[0]+ a[2]);
        int current = 0;
        for(int i=3; i< a.length ; i++){
            current = Math.max(m1+a[i], m2+a[i]);
            m1=m2;
            m2=m3;
            m3= current;
        }

        return Math.max(current, m2);
    }

    public static void main(String[]args) {
        int[] prices = {1, 3, 5, 4, 9};
        int[] prices_2 = {5, 1, 3, 11, 7};

        System.out.println(getMaxSumWithNeighour(prices));
        System.out.println(getMaxSumWithNeighour(prices_2));
        System.out.println(getMaxMethod2(prices));
        System.out.println(getMaxMethod2(prices_2));
        System.out.println(bestMethod(prices));
        System.out.println(bestMethod(prices_2));

    }
}
