class Solution {

    public static int m;
    public static int n;

    public static Boolean dp[][][];

    public boolean hasValidPath(char[][] grid) {

        m = grid.length;
        n = grid[0].length;

        dp = new Boolean[m][n][200];

        // return recursion(grid, 0, 0, "");
        // return validParan("()(())");
        return recursion(grid, 0, 0, 0);
        
    }

    // public static boolean recursion(char grid[][], int i, int j, String s){

    //     if(i == m-1 && j == n-1){
    //         // System.out.println(s + grid[i][j]);
    //         return validParan(s + grid[i][j]);
    //     }

    //     if(dp[i][j] != null){
    //         return dp[i][j];
    //     }

    //     boolean down = false;
    //     if(i + 1 < m){
    //         down = recursion(grid, i + 1, j, s + grid[i][j]);
    //     }
    //     boolean right = false;
    //     if(j + 1 < n){
    //         right = recursion(grid, i, j + 1, s + grid[i][j]);
    //     }

    //     return dp[i][j] = down || right;

    // }

    // public static boolean validParan(String s){

    //     Stack<Character> stk = new Stack<>();

    //     for(char c : s.toCharArray()){
    //         if(c == '('){
    //             stk.push(c);
    //         }else{
    //             if(!stk.isEmpty() && stk.peek() == '('){
    //                 stk.pop();
    //             }else{
    //                 stk.push(')');
    //             }
    //         }
    //     }

    //     return stk.isEmpty();

    // }

    public static boolean recursion(char grid[][], int i, int j, int curr){

        if(i >= m || j >= n){
            return false;
        }

        curr += (grid[i][j] == '(' ? 1 : -1);

        if(curr < 0){
            return false;
        }

        if(i == m-1 && j == n-1){
            return curr == 0;
        }

        if(dp[i][j][curr] != null){
            return dp[i][j][curr];
        }

        boolean down = recursion(grid, i + 1, j, curr);
        boolean right = recursion(grid, i, j + 1, curr);

        return dp[i][j][curr] = down || right;

    }
}
