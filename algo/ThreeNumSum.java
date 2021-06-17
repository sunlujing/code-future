package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三个数之和
 */
public class ThreeNumSum {

    public static List<List<String>> getCombEqualSum(int[]a, int target){
        if(a.length <3) return new ArrayList<List<String>>();
        Arrays.sort(a);
        List<List<String>> res = new ArrayList<List<String>>();
        for(int i =0; i < a.length -2; i++){
            if(i>0 && a[i] == a[i-1]) continue;

            int T = target -a[i];
            int s = i+1;
            int e = a.length-1;

            while(s < e) {
                if (T == a[s] + a[e]) {
                    List<String> oneRec = new ArrayList<String>();
                    oneRec.add(a[i] + "");
                    oneRec.add(a[s] + "");
                    oneRec.add(a[e] + "");
                    res.add(oneRec);
                    while (s < e && a[s] == a[s + 1]) ++s;
                    while (s < e && a[e] == a[e - 1]) --e;
                    ++s;--e;

                }else if (a[e] + a[s] < T) ++s;
                else --e;
            }
        }

        return res;

    }

    public static void main(String[]args){
        List<List<String>> res = getCombEqualSum( new int[]{1,1,1,1,1,1},4);
        System.out.println(res);
    }
}
