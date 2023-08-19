// Partition Equal Subset Sum

// Problem Link - https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1?page=2&sortBy=submissions

// Approach - Dynamic Programming (Recursion + Memoization)

class Solution{
    
    public static Boolean dp[][];
    
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum = 0;
        
        for(int a : arr){
            
            sum += a;
            
        }
        
        dp = new Boolean[sum/2 + 1][N + 1];
        
        if(sum % 2 != 0){
            return 0;
        }
        
        boolean ans = helper(arr, sum / 2, 0);
        
        return ans ? 1 : 0;
    }
    
    public static boolean helper(int arr[], int sum, int ind){
        
        if(sum == 0){
            return true;
        }
        
        if(ind == arr.length){
            return false;
        }
        
        if(dp[sum][ind] != null){
            return dp[sum][ind];
        }
        
        boolean notPick = helper(arr, sum, ind + 1);
        
        boolean pick = false;
        
        if(sum >= arr[ind]){
            pick = helper(arr, sum - arr[ind], ind + 1);
        }
        
        return dp[sum][ind] = pick || notPick;
        
    }
}
