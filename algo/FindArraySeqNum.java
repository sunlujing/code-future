package com.alipay.sofa.jraft.test.atomic.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindArraySeqNum {

    public static int getSeqNum(int[]a, int s){
        Map<Integer,Integer> countOfPrefix = new HashMap<Integer,Integer>();
        int[] prefixSum = new int[a.length];
        prefixSum[0]=a[0];
        countOfPrefix.put(a[0],1);
        int res = 0;
        for(int i=1; i<a.length; i++){
            prefixSum[i]=prefixSum[i-1]+a[i];
            if(countOfPrefix.containsKey(prefixSum[i])){
                countOfPrefix.put(prefixSum[i], countOfPrefix.get(prefixSum)+1);
            }else{
                countOfPrefix.put(prefixSum[i],1);
            }
            int target = prefixSum[i]-s;
            if(countOfPrefix.containsKey(target)){
                res += countOfPrefix.get(target);
            }
        }

        return res;

    }

    public static void main(String[]args){
        System.out.println(getSeqNum(new int[]{1,2,3,5,6,11},11));
    }
}
