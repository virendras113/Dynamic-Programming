// Coin Change

// Approach - Recursion + Memoization --> Space Optimization

class Solution {
    
    public static Long dp[][];
    
    public long count(int coins[], int N, int sum) {
        // code here.
        
        // dp = new Long[sum + 1][N + 1];
        
        // long res = recursion(coins, sum, 0);
        
        long res = spaceOpt(sum, coins);
        
        return res;
    }
    
    // public static long recursion(int coins[], int sum, int ind){
        
    //     if(ind == coins.length - 1){
            
    //         return sum % coins[ind] == 0 ? 1 : 0;
            
    //     }
        
    //     if(dp[sum][ind] != null){
    //         return dp[sum][ind];
    //     }
        
    //     long pick = 0;
        
    //     long notPick = recursion(coins, sum, ind + 1);
        
    //     if(coins[ind] <= sum){
    //         pick = recursion(coins, sum - coins[ind], ind);
    //     }
        
    //     return dp[sum][ind] = pick + notPick;
        
    // }
    public static long spaceOpt(int sum, int coins[]){
        
        long tab[] = new long[sum + 1];
        
        tab[0] = 1;
        
        for(int c : coins){
            
            for(int i=c; i<=sum; i++){
                
                tab[i] += tab[i - c];
                
            }
            
        }
        
        return tab[sum];
        
    }
}
