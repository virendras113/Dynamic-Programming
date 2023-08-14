// 1575. Count All Possible Routes

// Approach - Recursion -> Memoization (One parameter can be current city location whereas the other can be the fuel left at any point of time).

class Solution {

    public static int mod;

    public static Integer dp[][];

    public int countRoutes(int[] locations, int start, int finish, int fuel) {

        dp = new Integer[locations.length + 1][fuel + 1];

        mod = (int)Math.pow(10, 9) + 7;

        int ans = recursion(locations, start, finish, fuel);

        return ans;
        
    }

    public static int recursion(int loc[], int i, int f, int fuel){

        int ans = 0;

        if(i == f){
            // System.out.println(i);
            ans++;
        }

        if(dp[i][fuel] != null){
            return dp[i][fuel];
        }

        for(int ind = 0; ind < loc.length; ind++){

            if(ind != i && Math.abs(loc[i] - loc[ind]) <= fuel){
                // System.out.print(i + " ");
                ans = ans % mod + (recursion(loc, ind, f, fuel - (Math.abs(loc[i] - loc[ind])))) % mod;
            }

        }

        return dp[i][fuel] = ans % mod;

    }
}
