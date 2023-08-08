//70. Climbing Stairs

// Approach - DP (Recursion + Memoization + Tabulation)

class Solution {

    public static Integer dp[];

    public int climbStairs(int n) {

        // dp = new Integer[n + 1];

        // int ans1 = recursion(n);
        // int ans2 = memoization(n);
        int ans3 = tabulation(n);

        return ans3;
        
    }

    public static int recursion(int n){

        if(n == 1 || n == 2){
            return n;
        }

        return recursion(n-1) + recursion(n-2);

    }

    // public static int memoization(int n){

    //     if(n == 1 || n == 2){
    //         return n;
    //     }

    //     if(dp[n] != null){
    //         return dp[n];
    //     }

    //     return dp[n] = memoization(n-1) + memoization(n-2);

    // }

    public static int tabulation(int n){

        if(n == 1 || n == 2){
            return n;
        }

        int tab[] = new int[n + 1];

        tab[1] = 1;
        tab[2] = 2;

        for(int i=3; i<=n; i++){
            tab[i] = tab[i-1] + tab[i-2];
        }

        return tab[n];

    }
}
