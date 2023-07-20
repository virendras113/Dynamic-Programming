// Minimum steps to delete a string

// Approach - Dynamic Programming + Two Pointers {Memoized Solution}

// Link - https://www.geeksforgeeks.org/minimum-steps-to-delete-a-string-after-repeated-deletion-of-palindrome-substrings/
// Problem Link - https://practice.geeksforgeeks.org/problems/minimum-steps-to-delete-a-string2956/1

class Solution{
    
  public static Integer dp[][];

	public int minStepToDeleteString(String s) 
	{ 
	    // Your code goes here[]
	    
	    dp = new Integer[s.length()][s.length()];
	    
	    int ans = memoization(s, 0, s.length() - 1);
	    
	    return ans;
	    
	} 
	
	public static int memoization(String s, int l, int r){
	    if(l > r){
	        return 0;
	    }
	    
	    if(l == r){
	        return 1;
	    }
	    
	    if(dp[l][r] != null){
	        return dp[l][r];
	    }
	    
	    int opt1 = Integer.MAX_VALUE;
	    int opt2 = Integer.MAX_VALUE;
	    int opt3 = Integer.MAX_VALUE;
	    
	    opt1 = 1 + memoization(s, l + 1, r);
	    
	    if(s.charAt(l) == s.charAt(l + 1)){
	        opt2 = 1 + memoization(s, l + 2, r);
	    }
	    
	    for(int i=l + 2; i<=r; i++){
	        if(s.charAt(l) == s.charAt(i)){
	            opt3 = Math.min(opt3, memoization(s, l + 1, i - 1) + memoization(s, i + 1, r));
	        }
	    }
	    
	    return dp[l][r] = Math.min(opt1, Math.min(opt2, opt3));
	    
	}
}
