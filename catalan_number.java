// Nth Catalan Number

// Approach - Dynamic Programming

// Link - https://www.geeksforgeeks.org/program-nth-catalan-number/
// Problem Link - https://practice.geeksforgeeks.org/problems/nth-catalan-number0817/1

class Solution
{
    //Function to find the nth catalan number.
    public static BigInteger dp[];
    
    public static BigInteger findCatalan(int n)
    {
        //Your code here
        
        dp = new BigInteger[n + 1];
        
        BigInteger ans = tabulation(n);
        
        return ans;
        
    }
    
    public static BigInteger recur(int n){
        if(n <= 1){
            return new BigInteger("1");
        }
        
        if(dp[n] != null){
            return dp[n];
        }
        
        BigInteger ans = new BigInteger("0");
        
        for(int i=1; i<=n; i++){
            ans = ans.add(recur(i-1).multiply(recur(n-i)));
        }
        
        return dp[n] = ans;
    }
    
    public static BigInteger tabulation(int n){
        
        BigInteger tab[] = new BigInteger[n + 1];
        
        Arrays.fill(tab, new BigInteger("0"));
        
        tab[0] = new BigInteger("1");
        tab[1] = new BigInteger("1"); 
        
        for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
                
                tab[i] = tab[i].add(tab[j-1].multiply(tab[i-j]));
                
            }
        }
        
        return tab[n];
        
    }
}
