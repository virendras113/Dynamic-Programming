// Maximum Path Sum

// Approach - Recursion + Memoization

class Solution{
    
    public static Integer dp[][];
    
    static int maximumPath(int N, int grid[][])
    {
        // code here
        
        dp = new Integer[N][N];
        
        int maxSum = Integer.MIN_VALUE;
        
        for(int i=0; i<N; i++){
            
            int tempSum = recursion(grid, 0, i);
            
            maxSum = Math.max(tempSum, maxSum);
            
        }
        
        return maxSum;
    }
    
    public static int recursion(int grid[][], int i, int j){
        
        if(i == grid.length){
            return 0;
        }
        
        if(dp[i][j] != null){
            return dp[i][j];
        }
        
        int opt1 = grid[i][j] + recursion(grid, i + 1, j);
        int opt2 = Integer.MIN_VALUE;
        int opt3 = Integer.MIN_VALUE;
        
        if(j-1 >= 0){
            opt2 = grid[i][j] + recursion(grid, i + 1, j - 1);
        }
        
        if(j + 1 < grid[0].length){
            opt3 = grid[i][j] + recursion(grid, i + 1, j + 1);
        }
        
        return dp[i][j] = Math.max(opt1, Math.max(opt2, opt3));
        
    }
}
