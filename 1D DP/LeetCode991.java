// 991. Broken Calculator

// Approach - Recursion

class Solution {
    public int brokenCalc(int startValue, int target) {

        int ans = recursion(startValue, target);

        return ans;
        
    }

    public static int recursion(int s, int t){

        if(s > t){
            return s - t;
        }

        if(s == t){
            return 0;
        }

        if(t % 2 == 0){
            return 1 + recursion(s, t / 2);
        }else{
            return 1 + recursion(s, t + 1);
        }

    }
}
