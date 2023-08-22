// 2786. Visit Array Positions to Maximize Score

// Approach - Dynamic Programming (Recursion -> Memoization -> Tabulation)
//            Giving two parameters for our DP array * First being the modulus of the nuumber just to check that the number is even or odd, since there are only 2 popssiblities of even/ odd we keep the no. of rows only 2.


class Solution {

    public static Long dp[][];

    public long maxScore(int[] nums, int x) {

        // dp = new Long[2][nums.length + 1];

        // long res = nums[0] + recursion(nums, x, 1, nums[0] % 2);

        long tab = tabulation(nums, x);

        return tab;
        
    }

    // public static long recursion(int nums[], int x, int ind, int even){

    //     if(ind >= nums.length){
    //         return 0;
    //     }

    //     if(dp[even][ind] != null){
    //         return dp[even][ind];
    //     }

    //     long pick = 0;

    //     long notPick = recursion(nums, x, ind + 1, even);

    //     if(nums[ind] % 2 == even){
    //         pick = nums[ind] + recursion(nums, x, ind + 1, nums[ind] % 2);
    //     }else{
    //         pick = (nums[ind] - x )+ recursion(nums, x, ind + 1, nums[ind] % 2);
    //     }

    //     return dp[even][ind] = Math.max(pick, notPick);

    // }

    public static long tabulation(int nums[], int x){

        long tab[][] = new long[2][nums.length + 1];

        tab[0][nums.length] = 0;
        tab[1][nums.length] = 0;

        for(int i = nums.length - 1; i>=0; i--){

            for(int j = 0; j <= 1; j++){

                long pick = 0;
                long notPick = tab[j][i + 1];

                if(nums[i] % 2 == j){
                    pick = nums[i] + tab[j][i + 1];
                }else{
                    pick = nums[i] - x + tab[j == 0 ? 1 : 0][i + 1];
                }

                tab[j][i] = Math.max(pick, notPick);

            }

        }

        return tab[nums[0] % 2][0];

    }
}
