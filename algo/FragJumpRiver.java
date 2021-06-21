
/**
 * leetcode 403
 * [0,1,3,5,6,8,12,17]: true
 * [0,1,2,3,4,8,9,11]: false
 *
 * 设 到达 第 i 颗石头，且最后一跳 为k  能否达到。
 * d[i+1][k]:
 * for(int j=0;j<=i;j++):
 * 从前面任意一颗石头跳过来：
 *      gap = d[i+1] -d[j]
 *
 *       d[j][gap]
 *       d[j][gp-1]
 *       dp[j][gp+1]
 *
 *      有一个为true，那么就是true
 *
 */
public class FragJumpRiver {

    public static boolean canReach(int[]a){
        boolean dp[][] = new boolean[a.length][a.length+1];
        dp[0][0] = true;
        for(int i=1; i< a.length ;i++){
            for(int j=0; j<i; j++){
                int gap = a[i] - a[j];
                if(dp[j][gap] || dp[j][gap+1] || (gap-1>=0 && dp[j][gap-1])){
                    dp[j][gap] = true;
                }
            }
        }
        for(int i=0; i< a.length ;i++){
            if(dp[a.length-1][i]){
                return true;
            }
        }
        return false;
    }

}
