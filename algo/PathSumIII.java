package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * paht sum:
 * 1, 根节点到叶子节点 的路径 =SUM 的次数；
 * 2， 根节点到叶子节点，记录 所有路径
 * 3， 不局限于  根节点和叶子节点，子路径都可以；
 */
public class PathSumIII {
    public static int count = 0;
    public static List<List<Integer>> res = new ArrayList<>();

    public static int getSUm(Node root, int sum){
        dfs1(root, sum) ;
        return count;
    }

    public static void dfs1(Node root, int sum){
        if(root == null)return;
        if(root.v == sum && root.left == null && root.right == null) count++;
        dfs1(root.left, sum-root.v);
        dfs1(root.right, sum-root.v);
    }

    public static void dfs2(Node root, int sum, List<Integer> path){
        if(root == null)return;
        path.add(root.v);
        if(root.v == sum && root.left == null && root.right == null){
            res.add(path);
        };
        dfs2(root.left, sum-root.v, path);
        dfs2(root.right, sum-root.v,path);
        //need the trace back
        path.remove(root.v);
    }

    public static void internalPathSUm(Node root, int sum){
        // 核心，就是以root 节点，进行迭代；
        if(root == null) return;
        dfsRoot(root,sum);
        internalPathSUm(root.left, sum -root.v);
        internalPathSUm(root.right, sum-root.v);
    }

    public static void dfsRoot(Node root, int sum){
        if(root == null)return;
        if(root.v == sum) count++;
        dfs1(root.left, sum-root.v);
        dfs1(root.right, sum-root.v);
    }


    static class Node{
        Node left;
        Node right;
        int v;
    }
}
