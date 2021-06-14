package com.alipay.sofa.jraft.test.atomic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 arr 和一个整数 difference，请你找出 arr 中所有相邻元素之间的差等于给定 difference 的等差子序列，并返回其中最长的等差子序列的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 * 示例 2：
 *
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 * 示例 3：
 *
 * ==============
 *
 * 在 数组的动态规划里面，很多都是以 i 结尾的序列，为 d【i】
 * 然后在 di中找最大
 *
 * d[i]+1 = d[i-diff] +1;
 *
 *
 *
 */
public class LongestForGiveDiff {
    public static int getLongest(int[]a,int diff){
        int res = 1;
        Map<Integer,Integer> dp = new HashMap<Integer,Integer>();
        for(int i =0; i < a.length ;i++){
            dp.put(a[i],1);
            if(dp.containsKey(a[i]-diff)){
                dp.put(a[i], dp.get(i-diff) + 1);
            }
            res = Math.max(res,dp.get(a[i]));
        }
        return res;
        
    }
}
