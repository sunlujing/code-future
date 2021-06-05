/**
 * Given a list of integers nums, return the maximum length of a contiguous strictly increasing sublist if you can remove one or zero elements from the list.
 *
 * Constraints
 *
 * n ≤ 100,000 where n is the length of nums
 * Example 1
 * Input
 * nums = [30, 1, 2, 3, 4, 5, 8, 7, 22]
 * Output
 * 7
 * Explanation
 * If you remove 8 in the list you can get [1, 2, 3, 4, 5, 7, 22] which is the longest, contiguous, strictly increasing list.
 *
 * ############ 删除会带来两种状态
 * d[i], 不删除 i 节点，i 的最大连续
 * r[i], 删除i的 前一个节点，最大 连续
 *
 */

public class StrictlyIncreasingAfterDeletion {
    public static int getLongAfterDelete(int[] a){
        int[] d = new int[a.length];
        int[] r= new int[a.length];
        d[0] = 1;
        r[1] = 1;
        for(int i=1; i < a.length ; i++){
            int lx = 1;
            for(int j=i; j>0;j-- ){
                if(a[j] > a[j-1]){
                    lx++;
                }
            }
            d[i] = lx;


        }
        for(int i=2; i < a.length ; i++){
            if(a[i] > a[i-2]){
                r[i] = d[i-2]+1;
            }
        }

        int max = 0;
        for(int i=0; i< d.length; i++){
            if(d[i]>max){
                max = Math.max(d[i],max);
            }
            if(r[i]>max){
                max = Math.max(r[i],max);
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int[] n = new int[]{30, 1, 2, 3, 4, 5, 8, 7, 22};
        int max = getLongAfterDelete(n);
        System.out.println(max);
    }
}
