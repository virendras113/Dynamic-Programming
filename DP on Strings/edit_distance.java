// Edit Distance

// Approach - Dynamic Programming - We dont actually have to do operations on the string, instead we just have to maintain the pointers.
//            So the operations like - Replace - Both indices increaments by 1;
//                                     Delete and Insert - Either of the index increases by 1;

// Problem Link - https://practice.geeksforgeeks.org/problems/edit-distance3702/1?page=1&sortBy=difficulty

class Solution {
    
    public static Integer dp[][];
    
    public int editDistance(String s, String t) {
        // Code here
        
        dp = new Integer[s.length() + 1][t.length() + 1];
        
        int ans = recursion(s, t, 0, 0);
        
        return ans;
    }
    
    public static int recursion(String s, String t, int i, int j){
        
        if(j == t.length()){
            return s.length() - i;
        }
        
        if(i == s.length()){
            return t.length() - j;
        }
        
        if(dp[i][j] != null){
            return dp[i][j];
        }
        
        int opt1 = 0;
        int opt2 = 0;
        int opt3 = 0;
        
        if(s.charAt(i) == t.charAt(j)){
            return recursion(s, t, i + 1, j + 1);
        }else{
            opt1 = recursion(s, t, i, j + 1);
            opt2 = recursion(s, t, i + 1, j);
            opt3 = recursion(s, t, i + 1, j + 1);
        }
    
        return dp[i][j] = 1 + Math.min(Math.min(opt1, opt2), opt3);
        
    }
}
