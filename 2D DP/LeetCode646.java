// 646. Maximum Length of Pair Chain

// Approach - Dynamic Programming (Recursion -> Memoization)

class Solution {

    public static Integer dp[][];

    public int findLongestChain(int[][] pairs) {

        dp = new Integer[pairs.length][2005];

        Arrays.sort(pairs, (a,b) -> a[1] - b[1]);

        // for(int pair[] : pairs){
        //     System.out.print(Arrays.toString(pair) + " ");
        // }

        int ans = recursion(pairs, 0, -1001);

        return ans;
        
    }

    public static int recursion(int pairs[][], int ind, int prev){

        if(ind >= pairs.length){
            return 0;
        }

        if(dp[ind][prev + 1001] != null){
            return dp[ind][prev + 1001];
        }

        int pick = Integer.MIN_VALUE;

        if(pairs[ind][0] > prev){

            pick = 1 + recursion(pairs, ind + 1, pairs[ind][1]);

        }

        int notPick = recursion(pairs, ind + 1, prev);

        return dp[ind][prev + 1001] = Math.max(pick, notPick);

    }
}
