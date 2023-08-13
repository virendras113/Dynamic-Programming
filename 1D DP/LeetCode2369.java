// 2369. Check if There is a Valid Partition For The Array

// Approach - Dynamic Programming
// Mapping down the 3 possibilities of validness of an array, making the 3 different recursive calls for the same.

class Solution {

    public static Boolean dp[];
    public static int n;

    public boolean validPartition(int[] nums) {

        // dp = new Boolean[nums.length + 1];

        n = nums.length;

        // boolean res = recursion(nums, 0);
        // boolean res = memoization(nums, 0);
        boolean res = tabulation(nums);
        
        return res;

    }

    public static boolean recursion(int nums[], int ind){

        if(ind == n){
            return true;
        }

        boolean opt1 = false;
        boolean opt2 = false;
        boolean opt3 = false;

        if(ind + 1 < n && nums[ind] == nums[ind + 1]){

            opt1 = recursion(nums, ind + 2);

        }

        if(ind + 2 < n && nums[ind] == nums[ind + 1] && nums[ind] == nums[ind + 2]){

            opt2 = recursion(nums, ind + 3);

        }

        if(ind + 2 < n && nums[ind] == nums[ind + 1] - 1 && nums[ind] == nums[ind + 2] - 2){

            opt3 = recursion(nums, ind + 3);

        }

        return opt1 || opt2 || opt3;
        
    }

    public static boolean memoization(int nums[], int ind){

        if(ind == n){
            return true;
        }

        boolean opt1 = false;
        boolean opt2 = false;
        boolean opt3 = false;

        if(dp[ind] != null){
            return dp[ind];
        }

        if(ind + 1 < n && nums[ind] == nums[ind + 1]){

            opt1 = memoization(nums, ind + 2);

        }

        if(ind + 2 < n && nums[ind] == nums[ind + 1] && nums[ind] == nums[ind + 2]){

            opt2 = memoization(nums, ind + 3);

        }

        if(ind + 2 < n && nums[ind] == nums[ind + 1] - 1 && nums[ind] == nums[ind + 2] - 2){

            opt3 = memoization(nums, ind + 3);

        }

        return dp[ind] = opt1 || opt2 || opt3;

    }

    public static boolean tabulation(int nums[]){

        boolean tab[] = new boolean[n + 1];

        tab[n] = true;

        for(int i = n - 1; i>=0; i--){

            boolean opt1 = false;
            boolean opt2 = false;
            boolean opt3 = false;

            if(i + 1 < n && nums[i] == nums[i + 1]){
                opt1 = tab[i + 2];
            }

            if(i + 2 < n && nums[i] == nums[i + 1] && nums[i] == nums[i + 2]){
                opt2 = tab[i + 3];
            }

            if(i + 2 < n && nums[i] == nums[i + 1] - 1 && nums[i] == nums[i + 2] - 2){
                opt3 = tab[i + 3];
            }

            tab[i] = opt1 || opt2 || opt3;

        }

        return tab[0];

    }
}
