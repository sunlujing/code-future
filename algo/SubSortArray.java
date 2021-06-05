
/**
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 *
 * 示例：
 *
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 *
 *
 * 提示：
 *
 * 0 <= len(array) <= 1000000
 *
 * ## tips
 *
 * 画出这样一个 价格曲线，就知道，其实就是找局部最大，最小
 * 遍历过程中，记录最大最小， 能够知道波峰波谷
 */
public class SubSortArray {

    public static int[] getSubSort(int[] a) {
        int maxEnding = -1;
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < max) {
                maxEnding = i;
            }
            max = Math.max(max, a[i]);

        }
        int minEnding = -1;
        int min = Integer.MAX_VALUE;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] > min) {
                minEnding = i;
            }
            min = Math.min(min, a[i]);
        }

        return new int[]{minEnding, maxEnding};

    }

    public static void main(String[] args) {
        int[] n = new int[]{1,2,4,7,10,11,7,12,6,7,16,18,19};
        n = getSubSort(n);
        System.out.println(n[0]+" "+n[1]);
    }
