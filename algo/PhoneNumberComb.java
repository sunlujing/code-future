package com.alipay.sofa.jraft.test.atomic.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class PhoneNumberComb {


    public static  String letterMap[] = {
             "",
             "",
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    public static void getComb(int[]num){
        Set<String> result = new HashSet<>();
        dfs(num, 0, "", result);

        System.out.println(result);
    }

    public static void dfs(int[] num, int depth, String oneComb, Set<String> res){
        if(depth == num.length){
            //at the bottom of a tree
            res.add(oneComb);
            return ;
        }
        char[] chars = letterMap[num[depth]].toCharArray();
        for(int i =0; i< chars.length ; i++){
            dfs(num, depth+1, oneComb.concat(chars[i]+""), res);
        }
    }

    public static void main(String[]args){
        getComb( new int[]{2,3});
    }
}
