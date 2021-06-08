package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * //如果不返回结果，写起来会更简单；
 * 
 */
public class PalindromePartitioning {

    public static List<List<String>> partition(char[] s, int dep){
        if(dep == s.length-1){
            List<List<String>> result = new ArrayList<List<String>>();
            List<String> oneComb = new ArrayList<String>();
            oneComb.add(s[dep]+"");
            result.add(oneComb); return result;

        }
        List<List<String>> result = new ArrayList<List<String>>();
        for(int i=dep; i< s.length ; i++){
            if(isPalind(s, dep, i)){
                List<List<String>> left = partition(s, i+1);
                for(List<String> one: left){

                    List<String> path = new ArrayList<String>();
                    path.add(new String(s).substring(dep,i+1));
                    for (String s1 : one) {
                        path.add(s1);
                    }

                    result.add(path);
                }
            }
        }
        return result;
    }

    public static boolean isPalind(char[] a, int s, int e){
        while(s<=e){
            if(a[s]!=a[e]) return false;
            s++;
            e--;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res = partition(new char[]{'a','a','b'},0);
        System.out.println(res);
    }
}
