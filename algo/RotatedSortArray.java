package com.alipay.sofa.jraft.test.atomic.leetcode;

/**
 * 给你一个升序排列的整数数组 nums ，和一个整数 target 。
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
 *
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 *
 */
public class RotatedSortArray {

    public static int findTarget(int[]a, int t){
        int s =0, e=a.length-1;
        while(s <= e){
            int mid = s+(e-s)/2;
            if(t == a[mid]) return mid;

            if(a[mid] >= a[s]){
                //前半段有序
                if(t >= a[s] && t<a[mid]  ) e = mid-1;
                else{s = mid+1;}
            }else{
                //后半段有序
                if(t > a[mid] && t <= a[e]) s = mid + 1;
                else{e = mid -1;}
            }
        }
        return -1;
    }

    public static void main(String[]args){
        int[]a = {4,5,6,7,0,1,2};
        System.out.println(findTarget(a,4));
    }
}
