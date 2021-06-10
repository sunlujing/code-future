package com.leetcode;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * s：aaabeeeaaab，p: aaab
 * 输出:
 * [0, 6]
 *
 * =================
 * 字符串的问题，如果不是dp 就是滑动窗口；滑动窗口比较意思的。
 *
 * 窗口为 p 的长度， 使用hashmap 记录 p 中 字母的出现次数；
 * 在一个窗口中；比如
 * aaab aaab
 * a,  cnt_a=3,cntb=1
 * a, cnt_a =2;
 * a, cnt_a=1
 * a,cnt_0
 * b, cnt_b=0
 * 窗口为 k，且 cnt 数组中每个都为0；
 *
 * 异动窗口的时候，cnt 回加计数
 *
 *
 */

public class SlideWindowSubStringWithOrder {
}
