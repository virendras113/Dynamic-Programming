// Minimum Operations

// Approach - Dynamic Programming (Recursion + Memoization)

// Link - https://www.geeksforgeeks.org/minimize-steps-to-reach-k-from-0-by-adding-1-or-doubling-at-each-step/
// Problem Link - https://practice.geeksforgeeks.org/problems/find-optimum-operation4504/1

class Solution
{
    
    public static Integer dp[];
    
    public int minOperation(int n)
    {
        //code here.
        
        dp = new Integer[n + 1];
        
        int ans = memoization(n, 1);
        
        return ans + 1;
        
    }
    
    public static int recur(int n, int sum){
        if(sum == n){
            return 1;
        }
        
        if(sum > n){
            return 10000;
        }
        
        int opt1 = 1 + recur(n, sum * 2);
        int opt2 = 1 + recur(n, sum + 1);
        
        return Math.min(opt1, opt2);
    }
    
    public static int memoization(int n, int sum){
        
        if(n == sum){
            return 0;
        }
        
        if(sum > n){
            return 10000;
        }
        
        if(dp[sum] != null){
            return dp[sum];
        }
        
        int opt1 = 1 + memoization(n, sum * 2);
        int opt2 = 1 + memoization(n, sum + 1);
        
        return dp[sum] = Math.min(opt1, opt2);
        
    }
}
