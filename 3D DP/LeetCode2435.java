// 2435. Paths in Matrix Whose Sum Is Divisible by K

// Approach - Recursion + Memoization

class Solution {

    public static Integer dp[][][];

    public static int mod = (int)Math.pow(10, 9) + 7;

    public int numberOfPaths(int[][] grid, int k) {

        dp = new Integer[grid.length + 1][grid[0].length + 1][k + 1];

        int ans = recursion(grid, k, 0, 0, 0) % mod;

        return ans;
        
    }

    public static int recursion(int grid[][], int k, int i, int j, int sum){

        if(i == grid.length - 1 && j == grid[0].length - 1){
            if((sum + grid[i][j]) % k == 0){
                return 1;
            }else{
                return 0;
            }
        }

        if(dp[i][j][sum % k] != null){
            return dp[i][j][sum % k];
        }

        int down = 0;
        int right = 0;

        if(i + 1 < grid.length){
            down = recursion(grid, k, i + 1, j, sum + grid[i][j]) % mod;
        }

        if(j + 1 < grid[0].length){
            right = recursion(grid, k, i, j + 1, sum + grid[i][j]) % mod;
        }

        return dp[i][j][sum % k] = (down + right)%mod;

    }
}
