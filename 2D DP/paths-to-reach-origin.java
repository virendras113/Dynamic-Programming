// Number of Paths to reach origin

// Problem Link - https://practice.geeksforgeeks.org/problems/paths-to-reach-origin3850/1?page=1&category[]=Dynamic%20Programming&sortBy=difficulty

// Approach - Dynamic Programming (Recursion -> Memoization)

class Solution
{
    
    public static int i;
    public static int j;
    
    public static int mod = 1000000007;
    
    public static Integer dp[][];
    
    public static int ways(int n, int m)
    {
        // complete the function
        
        dp = new Integer[n + 1][m + 1];
        
        i = n;
        j = m;
        
        int ans = tabulation(n, m);
        
        return ans;
    }
    
    public static int recursion(int n, int m){
        
        if(n == 0 && m == 0){
            return 1;
        }
        
        if(n < 0 || m < 0){
            return 0;
        }
        
        if(dp[n][m] != null){
            return dp[n][m];
        }
        
        int left = recursion(n - 1, m) % mod;
        
        int up = recursion(n, m - 1) % mod;
        
        return dp[n][m] = (left + up) % mod;
        
    }
    
    public static int tabulation(int n, int m){
        
        int tab[][] = new int[n + 1][m + 1];
        
        tab[0][0] = 1;
        
        for(int i=1; i<=n; i++){
            tab[i][0] = 1;
        }
        
        for(int j=1; j<=m; j++){
            tab[0][j] = 1;
        }
        
        for(int i=1; i<=n; i++){
            
            for(int j=1; j<=m; j++){
                
                tab[i][j] = (tab[i-1][j] + tab[i][j-1]) % mod;
                
            }
            
        }
        
        return tab[n][m];
        
    }
}
