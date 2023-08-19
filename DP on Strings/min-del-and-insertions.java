// Minimum number of deletions and insertions

// Problem Link - https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1?page=2&sortBy=submissions

// Approach - Dynamic Programming (Recursion -> Memoization)

class Solution
{
    
    public static Integer dp[][];
    
    public static int n;
    public static int m;
    
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    
	    n = str1.length();
	    m = str2.length();
	    
	    dp = new Integer[n + 1][m + 1];
	    
	    int ans = recursion(str1, str2, 0, 0);
	    
	    return ans;
	} 
	
	public static int recursion(String s1, String s2, int i, int j){
	    
	    if(i == n && j == m){
	        return 0;
	    }
	    
	    if(i == n){
	        return m - j;
	    }
	    
	    if(j == m){
	        return n - i;
	    }
	    
	    if(dp[i][j] != null){
	        return dp[i][j];
	    }
	    
	    int opt1 = 0;
	    int opt2 = 0;
	    
	    if(s1.charAt(i) == s2.charAt(j)){
	        return recursion(s1, s2, i + 1, j + 1);
	    }else{
	        opt1 = recursion(s1, s2, i + 1, j);
	        opt2 = recursion(s1, s2, i, j + 1);
	    }
	    
	    return dp[i][j] = 1 + Math.min(opt1, opt2);
	    
	}
}
