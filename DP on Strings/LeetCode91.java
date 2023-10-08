// 91. Decode Ways

// Approach - Dynamic Programming (Recursion + Memoization)
           // We only have 2 options that is single digit for character or the double digit character. Once the index reaches the last we return 1.

class Solution {

    public static Integer dp[];

    public int numDecodings(String s) {

        dp = new Integer[s.length() + 1];

        // int ans1 = recursion(s, 0);
        int ans2 = memoization(s, 0);

        return ans2;
        
    }

    public static int recursion(String s, int i){

        if(i == s.length()){
            return 1;
        }

        if(s.charAt(i) == '0'){
            return 0;
        }

        int singleDig = recursion(s, i + 1);
        int doubleDig = 0;

        if(i < s.length() - 1 && Integer.parseInt(s.substring(i, i+ 2)) <= 26){

            doubleDig = recursion(s, i + 2);

        }

        return singleDig + doubleDig;

    }

    public static int memoization(String s, int i){

        if(i == s.length()){
            return 1;
        }

        if(s.charAt(i) == '0'){
            return 0;
        }

        if(dp[i] != null){
            return dp[i];
        }

        int singleDig = memoization(s, i + 1);
        int doubleDig = 0;

        if(i < s.length() - 1 && Integer.parseInt(s.substring(i, i + 2)) <= 26){

            doubleDig = memoization(s, i + 2);

        }

        return dp[i] = singleDig + doubleDig;

    }
}
