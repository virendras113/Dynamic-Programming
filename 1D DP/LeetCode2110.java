// 2110. Number of Smooth Descent Periods of a Stock

// Approach - Dynamic Programming

class Solution {
    public long getDescentPeriods(int[] prices) {

        long dp[] = new long[prices.length];

        long res = 0;

        dp[0] = 1;

        for(int i = 1; i < prices.length; i++){

            if(prices[i-1] - prices[i] == 1){
                dp[i] = dp[i-1] + 1;
            }else{
                dp[i] = 1;
            }

            res += dp[i];

        }

        System.out.println(Arrays.toString(dp));

        return res + 1;
        
    }
}
