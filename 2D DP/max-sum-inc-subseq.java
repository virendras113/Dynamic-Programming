// Maximum Sum Increasing Subsequence

// Problem Link - https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1?page=2&sortBy=submissions

// Approach - Dynamic Programming (Recursion -> Memoization -> Tabulation)

class Solution
{
    
    public static Integer dp[][];
    
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    
	    HashSet<Integer> hset = new HashSet<>();
	    
	    for(int a : arr){
	        hset.add(a);
	    }
	    
	    int uniArr[] = new int[hset.size()];
	    int ind = 0;
	    
	    for(int h : hset){
	        uniArr[ind++] = h;
	    }
	    
	    dp = new Integer[n + 1][hset.size() + 1];
	    
	    Arrays.sort(uniArr);
	    
	    return tabulation(arr, uniArr, n, uniArr.length);
	    
	}
	
	public static int helper(int a[], int b[], int n, int m){
	    
	    if(n == 0 || m == 0){
	        return 0;
	    }
	    
	    if(dp[n][m] != null){
	        return dp[n][m];
	    }
	    
	    int pick = 0;
	    
	    if(a[n - 1] == b[m - 1]){
	        return a[n - 1] + helper(a, b, n - 1, m - 1);
	    }
	    
	    return dp[n][m] = Math.max(helper(a, b, n - 1, m), helper(a, b, n, m - 1));
	    
	}
	
	public static int tabulation(int a[], int b[], int n, int m){
	    
	    int tab[][] = new int[n + 1][m + 1];
	    
	    for(int i = 0; i<=n; i++){
	        for(int j = 0; j<=m; j++){
	            if(i == 0 || j == 0){
	                
	               tab[i][j] = 0;
	                
	            }
	        }
	    }
	    
	    for(int i = 1; i <= n; i++){
	        
	        for(int j = 1; j <= m; j++){
	            
	            if(a[i-1] == b[j-1]){
	                tab[i][j] = a[i-1] + tab[i-1][j-1];
	            }else{
	                tab[i][j] = Math.max(tab[i-1][j], tab[i][j-1]);
	            }
	            
	        }
	        
	    }
	    
	    return tab[n][m];
	    
	}
}
