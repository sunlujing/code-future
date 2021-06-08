package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * #########################
 *
 * 求二叉查找数的个数；
 * 另外一个变种题目，就是要答应所有的二叉树，需要记录
 *
 */
public class MaxNumOfBinTree {

    public static int getBTreeNum(int n){

        if(n<=1) return 1;
        int res = 0;
        for(int i=1; i<= n; i++){
            res += getBTreeNum(i-1) * getBTreeNum(n-i);
        }
        // 在这里可能会超时，应为只是计算个数的话会有很多重复的子问题。
        //可以使用一个数组记录重复的子问题；
        return res;
    }


    public static List<String> getTrees(int first, int last){
        if(first > last) { List<String> res = new ArrayList<String>(); res.add("Null"); return res;}
        List<String> res = new ArrayList<String>();
        for(int i = first; i<=last; i++){
            List<String> left = getTrees(first, i-1);
            List<String> right = getTrees(i+1, last);
            for(String l: left){
                for(String r: right){
                    res.add( i+ l + r);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> res = getTrees(1,3);
        for(String s : res) System.out.println(s);
    }
}
