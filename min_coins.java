// Minimum number of Coins

// Approach - Greedy (Iterative)

// Link - https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
// Problem Link - https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1

class Solution{
    
    static List<Integer> minPartition(int N)
    {
        // code here
        
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        
        List<Integer> res = new ArrayList<>();
        
        while(N > 0){
            for(int i=coins.length - 1; i>=0; i--){
                if(coins[i] <= N){
                    N -= coins[i];
                    res.add(coins[i]);
                    break;
                }
            }
        }
        
        return res;
        
    }
}
