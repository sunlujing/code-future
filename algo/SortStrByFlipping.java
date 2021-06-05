package com.leetcode;

/**
 * You are given a string s consisting of the letters "x" and "y". In addition, you have an operation called flip, which changes a single "x" to "y" or vice versa.
 *
 * Determine the smallest number of times you would need to apply this operation to ensure that all "x"'s come before all "y"'s.
 *
 * Constraints
 *
 * 0 ≤ n ≤ 100,000 where n is the length of s
 * Example 1
 * Input
 * s = "xyxxxyxyy"
 * Output
 * 2
 * Explanation
 * It suffices to flip the second and sixth characters.
 * 爆力解法，n2；遍历零界点，n，然后求 前面的 y 的个数，和后面的x 个数；
 * 最优解，前面的 y 的个数 和 x 个数是很容易知道的，遍历的时候记录下来即可：
 * 那么后面的 x 就是，总数减去前面的 x数。
 *
 * 主要考察的就是 遍历的过程中记录有用的状态，减少时间消耗。
 *
 */
public class SortStrByFlipping {

    public static int flipStr(int[] s){
        int c_x =0, c_y =0;
        for(int i=0; i < s.length ; i++){
            if(s[i] ==0 ) c_x +=1;
        }
        int res = s.length;
        for(int i=0; i<s.length;i++){
            if(s[i]==0){
                c_x=c_x-1;
            }
            res = Math.min(res, c_x+c_y);
            if(s[i]==1){
              c_y=c_y+1;
            }

        }
        return res;

    }

    public static void main(String[] args) {
        int[] n = new int[]{0,1,0,0,0,1,0,11};
        System.out.println(flipStr(n));
    }
}
