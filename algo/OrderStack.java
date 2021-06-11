package com.leetcode;

import java.util.Stack;

/**
 * 把单调栈的相关问题做一个集合： https://blog.csdn.net/lucky52529/article/details/89155694
 *
 * 1， 对于一个 集合 [1, 3, 4, 5, 6, 4] 找到 坐标 i, j, k,  a_i < a_k < a_j, 也就是 1—3-2 的模式
 *
 * 2， 描叙：有n个人站队，所有的人全部向右看，个子高的可以看到个子低的发型，给出每个人的身高，问所有人能看到其他人发现总和是多少。
 * 输入：4 3 7 1
 * 输出：2

   3， 给定一个数组，2，1，5，6，2，3， 为柱状图，求 最大的组成的矩形面积；

   4， 描述：给出一组数字，求一区间，使得区间元素和乘以区间最小值最大，结果要求给出这个最大值和区间的左右端点
 输入：3 1 6 4 5 2
 输出：60
        3 5
 解释：将3到5（6+4+5）这段区间相加，将和与区间内最小元素相乘获得最大数字60
 思路：使用暴力解法求出所有区间，再求出区间的最小值相乘跟新数据，并不是一种很好的算法，所以经过上面俩题的磨炼，此时我们应该使用一个单调递减栈

      ###  单调栈：
     对于 任意一个 滑动窗口； i， j， 你可以很方便的维护 ，这个区间里面，最大，最小 和 次大，和次小的值；
     适合的场景； 滑动窗口，要看 递增，然后 转折 的递减 的； 就是处理波段的能力；

 */
public class OrderStack {
    /**
     *  核心就是， 从后往前看； 维护 两个高峰；这样就特别容易；
     *  维护一个 单调递增的栈， 遇到 高峰； 就全部pop出来，记录 第二大的；
     *  就是 单调栈维护 两个高峰；
     * @param a
     * @return
     */
    public static boolean find132Mode(int[]a){
        Stack<Integer> stack = new Stack<Integer>();
        int second = Integer.MIN_VALUE;
        for(int j=a.length-1; j>=0; j--){
            if(a[j] < second) return true;

            while(a[j]>=second && !stack.isEmpty()){
                int top  = stack.peek();
                if(a[j] > top){
                    second = top;
                }
                stack.pop();
            }

            stack.push(a[j]);
        }
        return false;
    }

    public static int whoCanSeeOthers(int[] a){
        Stack<Integer> stack = new Stack<Integer>();
        int total = 0;
        int top = Integer.MIN_VALUE;
        for(int i=0; i< a.length ;i++) {
            if(!stack.isEmpty() && a[i]< stack.peek()) total++;
            while(!stack.isEmpty() && a[i] > stack.peek()){
                top = stack.pop();

            }
            stack.push(a[i]);
        }

        return stack.size();
    }

    /**
     *    3， 给定一个数组，2，1，5，6，2，3， 为柱状图，求 最大的组成的矩形面积；
     *
     *    滑动窗口；下降趋势中的元素在后面一定不会用到； 但是还需要看下降趋势最低点与 前序 上升 关系的大小，所以用栈存起来；
     *    比他 大的都要pop，那么就是一个 递减 stack;
     *
     * @param a
     * @return
     */
    public static int getMaxRetange(int[]a){
        return 0;
    }

    // 上升趋势 最优秀 ，2，1，4，5 ，2， 所有包含1 的区间不如包含2的区间；


    public static void main(String[]args){
        System.out.print(find132Mode(new int[]{1, 3, 4, 5, 6, 4}));
        System.out.print(whoCanSeeOthers(new int[]{1, 3, 11, 5,13, 4}));

    }

}
