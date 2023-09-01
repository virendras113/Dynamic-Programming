// Interleaved Strings

// Problem Link - https://practice.geeksforgeeks.org/problems/interleaved-strings/1?page=1&sortBy=submissions

// Approach - Dynamic Programming (Recursion)

class Solution {
    
    public static Integer dp[][][];
    
	public boolean isInterLeave(String a,String b,String c)
	{
            //Your code here
            
            dp = new Integer[a.length() + 1][b.length() + 1][c.length() + 1];
            
            for(int i=0; i<=a.length(); i++){
                
                for(int j=0; j<=b.length(); j++){
                    
                    Arrays.fill(dp[i][j], -1);
                    
                }
                
            }
            
            return recursion(a, b, c, 0, 0, 0);
            
	}
	
	public static boolean recursion(String a, String b, String c, int i, int j, int k){
	    
        if(k == c.length()){
            
            return (i == a.length() && j == b.length());
            
        }
        
        if(dp[i][j][k] != -1){
            return dp[i][j][k];
        }
        
        boolean res = false;
        
        if(c.charAt(k) == a.charAt(i) && i + 1 < a.length()){
            res = dp[i][j][k] = recursion(a, b, c, i + 1, j, k + 1);
        }
        
        if(res) return true;
        
        if(c.charAt(k) == b.charAt(j) && j + 1 < b.length()){
            res = recursion(a, b, c, i, j + 1, k + 1);
        }
        
        return dp[i][j][k] = res;
	    
	}
}
