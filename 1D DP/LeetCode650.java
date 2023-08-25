// 650. 2 Keys Keyboard

// Approach - Dynamic Programming (Recursion)

class Solution {
    public int minSteps(int n) {

        int ans = recursion(n, 1, 1);

        return ans;
        
    }

    public static int recursion(int n, int copy, int curr){

        if(curr == n){
            return 0;
        }

        if(n % curr == 0){
            copy = curr;
            curr += curr;
            return 2 + recursion(n, copy, curr);
        }else{
            curr += copy;
            return 1 + recursion(n, copy, curr);
        }

    }
}
