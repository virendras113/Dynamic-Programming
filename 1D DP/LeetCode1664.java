// 1664. Ways to make fair array

// Approach - Prefix Sum (Dynamic Programming)

class Solution {
    public int waysToMakeFair(int[] nums) {

        int oddSum[] = new int[nums.length];
        int eveSum[] = new int[nums.length];

        int eveS = 0;
        int oddS = 0;

        for(int i = 0; i < nums.length; i++){

            if(i % 2 == 0){
                eveS += nums[i];
            }else{
                oddS += nums[i];
            }

            oddSum[i] = oddS;
            eveSum[i] = eveS;
            
        }

        int ans = 0;

        int tempEve = oddS - oddSum[0];
        int tempOdd = eveS - eveSum[0];

        if(tempEve == tempOdd) ans++;

        for(int i = 1; i < nums.length; i++){

            tempEve = oddS - oddSum[i];
            tempOdd = eveS - eveSum[i];

            // System.out.println(tempOdd + " " + tempEve);

            if(i != 0){
                tempEve += eveSum[i - 1];
                tempOdd += oddSum[i - 1];
            }

            if(tempEve == tempOdd){
                ans++;
            }

        }

        return ans;
        
    }
}
