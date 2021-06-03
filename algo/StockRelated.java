package com.leetcode;

/**
 * 经典三连击：
 * 1，买卖一次，最大利润；
 * 2, 买卖多次，最大利润；
 * 3，买卖多次，其中中间有静默期
 */

public class Stock_one_trading {

    /**
     * 记录波谷，最大的利润，一定是买在最低点
     * @param prices
     * @return
     */
    public static int getMaxProfit(int[] prices){

        int min = prices[0];
        int profit = 0;

        for(int i=1; i < prices.length ; i++){
            if(prices[i]-prices[i-1] > 0){
                profit = Math.max(profit, prices[i]-min);
            }else{
                min = Math.min(min, prices[i] );
            }
        }
        return profit;
    }

    /**
     *  对于 i 时刻，
     *  最大的利润 d[i], 包含股票 i 的利润 最大 h[i] >=0
     *  对于 i+1 时刻，
     *  如果  i+ 1> i;   d[i+1] =Max(h[i]+delta, d[i]); h[i+1] = h[i]+delta
     *        i+1 < i;  d[i+1] = d[i];  h[i+1]= Max(h[i]+delta, 0)
     *
     *
     *
     * @param prices
     * @return
     */

    public static int getMaxProfitByDP(int[] prices){
        int[] dp = new int[prices.length];
        int [] h =  new int[prices.length];
        dp[0] = 0;
        h[0] = 0;
        for(int i=1; i < prices.length ; i++){
            if(prices[i]-prices[i-1] > 0){
                dp[i] = Math.max(h[i-1]+(prices[i]-prices[i-1]), dp[i-1]);
                h[i] = h[i-1]+(prices[i]-prices[i-1]);
            }else{
                dp[i]=dp[i-1];
                h[i] = dp[i-1]+(prices[i]-prices[i-1]);
            }
            if(h[i]<0) h[i] = 0;
        }
        return dp[prices.length-1];

    }

    /**
     * 可以多次买卖，就是抓住任何一个上升波段，炒股的最优解。
     * @param prices
     * @return
     */
    public static int maxProfitYouCanSellMulitpleTime(int[] prices) {
        int res = 0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i] > prices[i-1])
            {
                res += prices[i] - prices[i-1];
            }
        }
        return res;
    }


    /**
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)
     *
     * 设 第 i 天的 最大利润 为 d[i]
     *
     * 那么 第 i+1 天的 最大利润 是？
     *
     * 需要考虑i 天的状态。 i 持有股票/ 没有股票
     *
     * 设持有 股票 最大利润，h[i]， 不持有 N[i] 最大利润；
     *
     * h[i+1] = Max(h[i], N[i-1]- prices[i+1])
     * N[i+1] = Max(N[i],h[i]+prices[i+1])
     *
     *
     * @param prices
     * @return
     */
    public static int maxProfitWithCoolDown(int[] prices) {
        int h[] = new int[prices.length];
        int n[] = new int[prices.length];

        h[0]=-1 * prices[0];
        n[0]=0;
        h[1]=Math.max(h[0],n[0]-prices[1]);
        n[1]=Math.max(n[0],h[0]+prices[1]);

        for(int i=1; i < prices.length-1 ; i++){
            h[i+1] = Math.max(h[i], n[i-1]- prices[i+1]);
            n[i+1] = Math.max(n[i],h[i]+prices[i+1]);
        }

        return Math.max(h[prices.length-1],n[prices.length-1]);
    }

    public static void main(String[]args){
        int[] prices = {7,1,5,3,6,7,3,5};
        int[] prices_2 = {7,6,4,3,1};


        System.out.println(getMaxProfit(prices));
        System.out.println(getMaxProfitByDP(prices));
        System.out.println(getMaxProfit(prices_2));
        System.out.println(getMaxProfitByDP(prices_2));

        System.out.println(maxProfitWithCoolDown(prices));
        System.out.println(maxProfitWithCoolDown(prices_2));
    }
}
