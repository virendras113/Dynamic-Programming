// 1884. Egg Drop with 2 Eggs and N Floors

// Approach - Dynamic Programming (Recursion -> Memoization)

class Solution {

    public static Integer dp[][];

    public int twoEggDrop(int n) {

        dp = new Integer[n + 1][3];

        int ans = recursion(n, 2);

        return ans;
        
    }

    public static int recursion(int n, int egg){

        if(n == 0 || n == 1){
            return n;
        }

        if(egg == 1){
            return n;
        }

        if(dp[n][egg] != null){
            return dp[n][egg];
        }

        int ans = Integer.MAX_VALUE;

        for(int i=1; i<=n; i++){
            int drop = recursion(i-1, egg-1);
            int keep = recursion(n-i, egg);

            int tempAns = Math.max(drop, keep);

            if(tempAns < ans){
                ans = tempAns;
            }
        }

        return dp[n][egg] = ans + 1;

    }
}
