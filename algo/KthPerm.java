package com.leetcode;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class KthPerm {

    public static void getKthPerm(int n, int k){

        int[] firstKey = getFirstKey(n,k);
        String str = "";
        n--;
        while(firstKey[0] !=0){
            str = str.concat(firstKey[0]+"");
            firstKey = getFirstKey(n, firstKey[1]);
            n--;
        }
        //补全
    }

    public static int[] getFirstKey(int n, int k){
        int[] res = new int[2];

        if(n==1) return new int[]{0,k};

        int f = doFactorial(n-1);
        int m = k%f;
        int t = k/f;
        if(m == 0 ){
            res[0] = t;
            res[1] = 0;

        }else {
            res[0]= t+1;
            res[1] = k - f*t;
        }
        return res;
    }

    public static int doFactorial(int n){
        int result = 1;
        if(n<0){
            return -1;//返回-1，说明传入数据不合法
        }
        if(n==0){
            return 1;
        }
        for(int i =1;i<=n;i++){
           result*=i;
         }
            return result;
    }

    public static void main(String[] args) {
        getKthPerm(4,6);
    }
}
