package com.alipay.sofa.jraft.test.atomic.leetcode;


/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点  (i, ai) 。在坐标内画 n 条垂直线，垂直线 i  的两个端点分别为  (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与  x  轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且  n  的值至少为 2。
 *
 * ![11.container-with-most-water-question](https://tva1.sinaimg.cn/large/007S8ZIlly1ghlu4wyztmj30m90anwep.jpg)
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为  49。
 *
 * 示例：
 * `
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * ### 双指针
 *   1，  7  的时候，  下一步就不用 在算 1-3，1-8 了。
 *   因为肯定小于 1-7的结果， 这就可以把 n*n 的问题给简化很多。
 *
 *
 */
public class ContainerWithWater {

    public static int getMaxWater(int[]a){
        int s=0, e=a.length-1;
        int max = 0;
        while(s < e){
            int cur = Math.min(a[s],a[e]) * (e-s);
            max = Math.max(cur, max);
            if(a[s] <= a[e]) s ++;
            else e--;
        }
        return max;
    }

    public static void main(String[]args){
        int[]a = {1,8,6,2,5,4,8,3,7};
        System.out.println(getMaxWater(a));
    }
}
