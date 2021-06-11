package com.leetcode;

/**
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 *
 * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,2,2]
 * 输出: true
 *
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 *
 * ============
 *
 * 转化为 sum/4 的情况；找 4个 集合，每个集合 = k;
 *
 *
 */
public class MatchStickSquare {

    public static boolean findSquare(int[] a){
        int sum =0;
        for(int i=0; i< a.length; i++){
            sum+=a[i];
        }
        if(sum%4!=0) return false;

        int[] ks = new int[4];

        return dfs(a, 0, ks, sum/4);

    }

    public static boolean dfs(int[]a, int depth, int[] ks, int target){
        if(depth == a.length){
            //finish one round search
            return (ks[0]==ks[1]) && ks[1]==ks[2] && ks[2]==ks[3] && ks[3] == target;
        }
        for(int i=0; i< ks.length ;i++){
            ks[i] = a[depth] + ks[i];
            if(dfs(a, depth+1, ks, target)){
                return true;
            }
            ks[i] -=a[depth];
        }
        return false;
    }

    public static void main(String[]args){
        System.out.println(findSquare(new int[]{4,4,4,2,2}));
    }

}
