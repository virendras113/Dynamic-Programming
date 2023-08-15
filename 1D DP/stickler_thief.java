// Stickler Thief

// Problem Link - https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

// Approach - Dynamic Programming (Recursion -> Memoization -> Tabulation)

class Solution
{
    //Function to find the maximum money the thief can get.
    
    public static Integer dp[];
    
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        dp = new Integer[n + 1];
        
        // int ans = recursion(arr, 0, n);
        int ans = tabulation(arr, n);
        
        return ans;
    }
    
    public static int recursion(int arr[], int ind, int n){
        
        if(ind >= n){
            return 0;
        }
        
        if(dp[ind] != null){
            return dp[ind];
        }
        
        int pick = arr[ind] + recursion(arr, ind + 2, n);
        
        int notPick = recursion(arr, ind + 1, n);
        
        return dp[ind] = Math.max(pick, notPick);
        
    }
    
    public static int tabulation(int arr[], int n){
        
        int tab[] = new int[n + 2];
        
        tab[n] = 0;
        tab[n + 1] = 0;
        
        for(int i = n - 1; i >= 0; i--){
            
            int pick = tab[i + 2] + arr[i];
            
            int notPick = tab[i + 1];
            
            tab[i] = Math.max(pick, notPick);
            
        }
        
        return tab[0];
        
    }

}
