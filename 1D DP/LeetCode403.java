// 403. Frog Jump

// Approach - DP (Recursion + Memoization)

class Solution {

    public static Boolean dp[][];

    public boolean canCross(int[] stones) {

        dp = new Boolean[stones.length][stones.length - 1];

        return recur(stones, 0, 0, stones[0]);
    }
    private boolean recur(int stones[], int index, int curr,int k){

        while(index < stones.length && curr > stones[index]){
            index++;
        }
        
        if(curr == stones[stones.length-1]) return true;
        else if(index >= stones.length || curr != stones[index]) return false;

        if(dp[index][k] != null) return dp[index][k];

        boolean opt1 = recur(stones, index + 1, curr + k - 1, k - 1);
        boolean opt2 = recur(stones, index + 1, curr + k, k);
        boolean opt3 = recur(stones, index + 1, curr + k + 1, k + 1);

        return dp[index][k] = opt1 || opt2 || opt3;
    }
}
