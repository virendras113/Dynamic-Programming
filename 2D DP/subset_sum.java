// Subset Sum

// Approach - Recuursion + Memoization

class Solution{
    
    public static Integer dp[][];

    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        
        dp = new Integer[sum + 1][N];
        
        return recursion(arr, sum, 0);
        
    }
    
    public static boolean recursion(int arr[], int sum, int ind){
        
        if(ind == arr.length - 1){
            return sum == 0 || sum == arr[ind];
        }
        
        if(dp[sum][ind] != null){
            return dp[sum][ind] == 1;
        }
        
        boolean pick = false;
        
        boolean notPick = recursion(arr, sum, ind + 1);
        
        if(arr[ind] <= sum){
            pick = recursion(arr, sum - arr[ind], ind + 1);
        }
        
        if(pick || notPick){
            dp[sum][ind] = 1;
        }else{
            dp[sum][ind] = 0;
        }
        
        return pick || notPick;
        
    }
}
