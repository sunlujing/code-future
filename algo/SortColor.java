package com.leetcode;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,1,0,1,0]  2 2 1 1 0 0 2 2
 * 输出: [0,0,1,1,2,2]
 * o(N)一趟扫描
 *
 * 和快速排序的思路有点像，移动位置
 */
public class SortColor {

    public static int[] sortArray(int[] a){

        int i =0;
        int s = 0;
        int e = a.length-1;
        while(s<=e &&  i< e){
            if(a[i] == 2 ){
                //swap
                int temp =a[e];
                a[e] = a[i];
                a[i] = temp;
                e--;
            }else if(a[i]==0 ){
                //swap
                int temp =a[s];
                a[s] = a[i];
                a[i] = temp;
                s++;
                i++;
            }else{
                i++;
            }

        }
        return a;
    }

    public static void main(String[] args) {
        int[] n = new int[]{1,1,2,2,1,1,0,0};
        n = sortArray(n);
        for(int i =0; i< n.length; i++){
            System.out.print(n[i] + " ");
        }
        System.out.println();
    }

}
