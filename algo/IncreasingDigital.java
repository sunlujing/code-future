/**
 * Given an integer n, return the number of positive integers of length n such that the digits are strictly increasing.
 *
 * Example 1
 * Input
 * n = 2
 * Output
 * 36
 * Explanation
 * We have 12, 13, 14, ..., 89.
 *
 * Example 2
 * Input
 * n = 1
 * Output
 * 9
 *
 * ##############
 * n=1, 1 2 3; d[1][1]=1  d[1][2]=1
 * n=2 , 12 13 d[2][1]=  12, 13,14, 19
 * n=3,  123 124,  d[3][1], d[2][2...]
 *
 * d[n][j], 长度为 n， 开始的数字 为 j 的 个数
 * d[n+1][j]  =  sum(d[n][k]) k > j
 * 
 * 找出自问题的关系不容易： 动态规划的精华
 *
 */
public class IncreasingDigital {

    public static int getNums(int n){
        int[][] a = new int[n+1][10];
        for(int i=1; i< 10; i++){
            a[1][i]=1;
        }

        for(int i=2; i <=n ; i++){
            for(int j=1; j< 10; j++){
                for(int k =j+1;k<10;k++){
                    a[i][j]+=a[i-1][k];
                }
            }
        }

        int sum = 0;
        for(int i=1; i< a[n].length;i++){
            sum+=a[n][i];
        }
        return sum;

    }

    public static void main(String[] args) {
        int n = getNums(2);
        System.out.println(n);
    }

}
