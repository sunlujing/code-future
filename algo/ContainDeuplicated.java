package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1, t = 2
 *
 * ————————————————
 * 版权声明：本文为CSDN博主「seconp」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/FYSGXFZ/article/details/106883335
 *
 * ======================
 * 这题比较经典， 主要是有两个 点， 需要记录 数组 的元素， 已经 各个元素 的 index。
 * 当 t =0 , 可以把 元素  的  key , index 放在Map中， 但是 当 t > 0 的时候，就需要遍历所有的 元素；
 *
 * ## 这道题目的优化就是使用了， 桶， 把所有 差值 小于 t 的放入一个桶中；然后进行 比较；
 *
 * 现比较 k 个元素，然后 i+1, k+1....
 *
 *
 */
public class ContainDeuplicated {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (nums == null || k < 0 || t < 0){
            return false;
        }
        int key, value;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            key = nums[i] / (t + 1);
            value = nums[i];
            if (map.containsKey(key)){
                return true;
            }else {
                map.put(key, value);
                if(map.get(key - 1) != null && Math.abs(nums[i] - map.get(key - 1)) <= t) return true;
                if(map.get(key + 1) != null && Math.abs(nums[i] - map.get(key + 1)) <= t) return true;
                if (map.size() > k){
                    map.remove(Math.floorDiv(nums[i - k], (long) t + 1));
                }
            }
        }
        return false;

    }

}
