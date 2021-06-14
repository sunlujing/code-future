package com.alipay.sofa.jraft.test.atomic.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * //对于这种组合类的，多半就是递归，然后判断或者是减枝
 *
 *
 */
public class GenerateParenthese {

    public static void generate(int n){
        Set<String> res = new HashSet<>();

        dfs(n, 0,0, "", res);

        System.out.println(res);
    }

    public static void dfs(int depth, int l, int r, String path, Set<String> res){
        if(l== depth && l == r){
            res.add(path);
            return;
        }
        if(r>l || l >depth || r >depth) return;

        dfs(depth, l+1,r, path+"(", res);
        if(l!=0) {
            dfs(depth, l, r + 1, path+")", res);
        }
    }

    public static void main(String[]args){
        generate( 4);
    }
}
