package com.leetcode;

/**
 * You are given integers n and k. Given that n represents the number of games you will play, return the number of ways in which you win k or less games consecutively. Mod the result by 10 ** 9 + 7.
 *
 * Constraints
 *
 * n ≤ 10,000
 * k ≤ 10
 * Example 1
 * Input
 * n = 3
 * k = 2
 * Output
 * 7
 * Explanation
 * Here are the ways in which we can win 2 or fewer times consecutively:
 *
 * "LLL"
 * "WLL"
 * "LWL"
 * "LLW"
 * "WWL"
 * "LWW"
 */
public class ConsecutiveWins {

    public static int conswins(int n, int k){
        return round(n,k,0,0);
    }

    public static int round(int n, int k, int r, int c){
       if(r == n){
           //第 n 轮
           return 1;
       }
       int left = round(n,k ,r+1, 0);
       if(c < k){
           left +=  round(n,k, r+1,c+1);
       }
       return left;
    }

    public static void main(String[] args) {
        int n = conswins(3,2);
        System.out.println(n);
    }

}
