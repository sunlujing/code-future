package com.leetcode;

/**
 * 经典排序，快排序，merege， 冒泡
 */
public class SortAlgo {

    /**
     * 经典的 从 第一个开始，往后冒泡
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[]arr){
        if(arr.length == 1) return arr;

        for(int i =0 ; i<arr.length-1 ; i++) {
            for(int j=0 ; j<arr.length-1-i ; j++) {
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }

    /**
     * 从最后一个开始，往前插入。
     * 一轮下来，一定会把最大或者最小的元素，移动到 正确的位置
     * @param arr
     * @return
     */
    public static int[] insertSort(int [] arr){
        for(int i =0 ; i<arr.length-1 ; i++) {
            for(int j= arr.length-1 ; j>i ; j--) {
                if(arr[j]<arr[j-1]) {
                    int temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
        return arr;
    }


    /**
     * quiksort
     * @param a
     */
    public static int[] quickSort(int[]a, int start, int end){
        if(start < end){
            int mid = partition(a, start, end);
            quickSort(a, start,mid-1);
            quickSort(a,mid+1,end);
        }

        return a;

    }

    //5, 1, 3, 11, 7
    public static int partition(int[] a, int start, int end){
        int privot = a[start];
        int i=start,j=end;
        while(i < j){

            while( i< j && a[i+1]< privot) i++;
            while(i<j && a[j] > privot) j--;

            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        a[start] = a[i];
        a[i]=privot;
        return i;
    }


    public static int[] mergeSort(int[] a, int s, int e){

        if(s< e){
            int mid = (s+e)/2;
            mergeSort(a, s,mid);
            mergeSort(a,mid+1,e);
            merge(a, s, mid,mid+1, e);
        }
        return a;
    }

    public static void merge(int[]a, int s1, int e1,
                             int s2, int e2){
        int ss = s1;
        int[] temp = new int[e2-s1+1];
        int k =0;
        while(s1 <= e1 && s2 <= e2){
            if(a[s1] < a[s2]){
                temp[k] = a[s1];
                s1++;
            }else{
                temp[k] = a[s2];
                s2++;
            }
            k++;
        }

        while(s1 <= e1){
            temp[k++] = a[s1]; s1++;
        }
        while(s2 <= e2){
            temp[k++] = a[s2]; s2++;
        }
        for(int i=0; i < temp.length; i++){
            a[ss+i] = temp[i];
        }

    }

    public static void main(String[]args) {
        int[] prices_2 = {5, 1, 3, 11, 7};
        prices_2 =  bubbleSort(prices_2);
        for(int i=0; i < prices_2.length ; i ++){
            System.out.print(prices_2[i]+" ");
        }
        int[] p = {5, 1, 3, 11, 7};
        p =  insertSort(p);
        for(int i=0; i < p.length ; i ++){
            System.out.print(p[i]+" ");
        }
        int[] c = {5, 1, 3, 11, 7};

        c =  quickSort(c,0,c.length-1);
        for(int i=0; i < c.length ; i ++){
            System.out.print(c[i]+" ");
        }

        int[] d = {5, 1, 3, 11, 7};

        d =  mergeSort(d,0,d.length-1);
        for(int i=0; i < d.length ; i ++){
            System.out.print(d[i]+" ");
        }
    }
}
