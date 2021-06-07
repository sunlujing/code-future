package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * 求 子集合是一类问题，求所有与a 相关的，包含a 的，包含b 的，包含c的。一个个拆分子问题。
 * 动态规划的一个解： 1, 1,2 , 1,2+ a[j]; a[i+1]= a[i]+j ;
 *
 *
 *
 */
public class SubSetOfCollection {

    public static void subSet(int[] a){
        List<String> result = new ArrayList<String>();
        search(a, 0, "",result);
        System.out.println(result);
    }

    public static void search(int a[], int depth, String comb, List<String> res){
        res.add(comb);
        for(int i=depth; i< a.length; i++ ){
            comb=comb.concat(a[i]+"");
            search(a, depth+1, comb, res);
            comb = comb.substring(0, comb.length()-1);
        }
    }


    public static void AllPerm(int[] a){
        List<String> result = new ArrayList<String>();
        searchPerm(a, 0, "",result);
        System.out.println(result);
    }

    public static void searchPerm(int a[], int depth, String path, List<String> res){
        if(depth == a.length ){ res.add(path);return;}
        for(int i=depth; i< a.length; i++ ){

            int temp = a[i];
            a[i] = a[depth];
            a[depth ] = temp;

            searchPerm(a, depth+1, path.concat(a[depth]+""), res);

            temp = a[i];
            a[i] = a[depth];
            a[depth ] = temp;
        }
    }

    public static void main(String[] args) {
        int[] n = new int[]{1,2,3};
        subSet(n) ;
        AllPerm(n) ;
    }

}
