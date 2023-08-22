// Player with max score

// Approach - Dynamic Programming (Recursion -> Memoization)

class Solution{
    
    public static Integer dp[][];

    static Boolean is1winner(int N, int arr[]){
        // code here
        
        dp = new Integer[N + 1][N + 1];
        
        int sum = 0;
        
        for(int a : arr){
            sum += a;
        }
        
        int ans = recursion(arr, 0, N - 1);
        
        return ans >= sum - ans;
        
    }
    
    public static int recursion(int arr[], int i, int j){
        
        if(i > j){
            return 0;
        }
        
        if(dp[i][j] != null){
            return dp[i][j];
        }
        
        int left = Math.min(recursion(arr, i + 1, j - 1), recursion(arr, i + 2, j)) + arr[i];
        
        int right = Math.min(recursion(arr, i + 1, j - 1), recursion(arr, i, j - 2)) + arr[j];
        
        return dp[i][j] = Math.max(left, right);
        
    }
}
