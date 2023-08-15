// 2311. Longest Binary Subsequence Less Than or Equal to K

/* Approach - Dynamic Programming (Recursion -> Memoization)
              We are not acutally building up the string, instead we will keep a track on the sum that we can obtain from the string we are trying to build.
              0/1 Knapsack approach helper to choose the maximum length we can obtain keeping in mind that the sum shouldn't cross K.

              Dependent factors in the recursive call is the - 1) Power 
                                                               2) Index

                                                          
*/       

class Solution {

    public static Integer dp[][];

    public int longestSubsequence(String s, int k) {

        dp = new Integer[s.length()][s.length()];

        int ans = recursion(s, k, s.length() - 1, 0, 0);

        return ans;
        
    }

    public static int recursion(String s, int k, int ind, int currSum, int pow){

        if(ind < 0){
            return 0;
        }

        if(dp[ind][pow] != null){
            return dp[ind][pow];
        }

        int pick = 0;

        int notPick = recursion(s, k, ind - 1, currSum, pow);

        int temp = s.charAt(ind) - '0';

        if(currSum + temp * Math.pow(2, pow) <= k){

            pick = 1 + recursion(s, k, ind - 1, currSum + temp * (int)Math.pow(2, pow), pow + 1);

        }

        return dp[ind][pow] = Math.max(pick, notPick);

    }
}
