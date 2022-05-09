数据结构&算法：
1)	字典树，存汉字那种。（一面原题）
2）写一个栈，增加一个方法，可以获取到栈中的最小值（剑指Offer 第30题）（二面原题）
3) 有个接口不断被调用，需要实现：如果该接口  “最近” 10分钟被调用次数超过1000，则不允许调用；
假定每次调用前都会访问下面这个静态方法，如果允许调用则返回true，否则返回false
public static boolean canInvoke(String methodName,String callerId){}(二面原题)
4) 链表问题，将链表后半段的节点插入前半段对应的位置，倒数一个插入到正数一个后面，倒数第二个到正数第二个后面，以此类推(二面原题)
 样例：Map={"A":"1","B":1,"C":{"D":[{"E":[{"F":"G"}]},{"E":[{"F":"G"}]}]}}和一个map的key层级layers=new String[]{"C","D","E"}，要求将"X":"Y"的这个key-value 按key层级{"C","D","E"}放置到E的节点下，形成诸如：
Map={"A":"1","B":1,"C":{"D":[{"E":[{"F":"G","X":"Y"}]},{"E":[{"F":"G","X":"Y"}]}]}}。
如果Map和layers都是输入参数，请编码实现放置的过程(一面原题)
5）带重复数字的二分，带重复数字的旋转二分（一面）
6)算法二选一，第一题：多线程爬虫，设计数据结构防止重复爬。第二题：字典序 第K大 数字（困难题），（二面原题）。
7) Map={"A":1,"B":"1","C":[{"D":2},{"E":2}]} ,根据String[] s = ["C","D"] ,然后放入 "X":"Y" 属性，最终Map={"A":1,"B":"1","C":[{"D":2,"X":"Y"},{"E":2}]}(一面原题)
8)快乐树（leetcode原题）
9）[0,1,2,3,4,5,6,7]有序数组折叠成[3,4,5,6,7,0,1,2]，找出开头的0（一面原题）
10）数组的所有子序列组合（一面原题）
11）设计一种数据结构，对爬虫的url进行去重，亿级数据量，需要考虑并发安全（二面原题）
12）字典排序（二面原题）
13) 打印两个升序链表的公共部分
限定语言：Python、C++、Java、Go、C、Javascript、Python 3
给定两个升序链表，按升序打印两个升序链表的公共部分。(二面原题)
14) 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
请你设计并实现时间复杂度为 O(n) 的算法解决此问题。来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-consecutive-sequence(一面原题)
15) 树的翻转;最长连续子串(一面原题);装箱算法
16) 求字符串中包含的最长连续子串（忽略大小写）(一面原题,高频题，最长连续子串指aaaAAAaaa这种)
17) 字符串找最长不重复子串（一面原题，比较高频）
18)有一个二维数组（n*n）,写程序实现从右上角到左下角沿主对角线方向打印。给定一个二维数组arr及题目中的参数n，请返回结果数组。（二面原题）
测试样例：
[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]],4
返回：
[4,3,8,2,7,12,1,6,11,16,5,10,15,9,14,13]
19）二叉树层序遍历（二面原题）
20)假设仓内有n个库位，每个库位中货物的数量0-10件。当给出一个目标库存数量需要拣货时，求解：如何选择库位使得整体占用的库位数量最少，并尽可能清空库位？（三面原题）
func choose(invs []int,target int) []int {}
Testcase:
1、10个库位：{10,9,8,7,4,5,6,7,2,8},目标库存40，给出占了哪几个库位
2、10个库位：{10,9,8,7,4,5,6,7,2,7},目标库存40，给出占了哪几个库位
3、10个库位：{10,9,8,8,4,5,6,6,2,6},目标库存40，给出占了哪几个库位
21）最长有效括号：给你一个只包含‘（’和‘）’的字符串，找出最长有效（格式正确且连续）括号子串的长度。（字节二面原题，题目是力扣上hrad题）
示例1：输入s=“（（）”，输出：2，解释：最长有效括号子串是“（）”
示例2：输入s=“）（）（））”，输出：4，解释:最长有效括号子串是“（）（）”
示例3：输入s=””,输出：0
///动态规划和 栈都很变态；

22）字符串的全排列（一面）///
全排列递归+回溯
23）有一个日志文件，记录用户登录抖音、登出抖音的时间，求每一时刻在线人数。（二面原题）查分数组；
A-B_C_D_E_F_G_H; 
然后根据 日志区间做差分； 

24）大数加法（一面：牛客网原题）
25）反转字符串中的单词（LeetCode原题）
26）数组题: 数字范围在0-n，数组长度也是n，找出每个数的出现次数（不是原题，但是思路类似，数组原地替换的思路）记录-1 为处理过的；

27）一亿个数取前一百，最快取（一面原题）



##### 2022-05-09
###### introduction
###### questions
- how graph works, neo4j, nebula, hugegraph;
- graphx details, spark details, core stage, narrow dep, bread dep; 
- spark optimization use cases; for examples【didn't use deep optimaztion】
- spark yarn schedular, what 's details. didn't have many knowledge;
- why use kafka, use cases; 
- why use flinks; details, didn't have many knowledge;
- java high concurrency，locks，latchdown，semphore；did't ask two many details;
- raft vs paxos; how raft select master;
##### algo
finaly alogrithom, find the longest path of sum of target in a binary tree;
##### question from me
talking about how deep we need to hanlde the open source techs. 
this team is all about big data,  need to know source code of spark, flink, hadoop ,k8s; 
i think i may not meet the requirement of their bars, considering i ask for a architech position;
as i didn't hanle complex scenaro , huge amount data and thousands of node cluster;

how to catch up that bar , it is a questions;
