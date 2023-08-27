// 1395. Count number of Teams

// Approach - Brute Force (Constraints not exceeding 1000 i.e. 10^3 we can try brute force -> T.C. => O(n^3)).
//            Dynamic Programming (Storing the answer of previously visited pairs and adding them up while working on the further elements of array).

class Solution {
    public int numTeams(int[] rating) {

        // Brute Force

        int ans = 0;

        // for(int i=0; i<rating.length - 2; i++){

        //     for(int j=i + 1; j<rating.length - 1; j++){

        //         for(int k=j + 1; k < rating.length; k++){

        //             if(rating[i] < rating[j] && rating[j] < rating[k]){
        //                 ans++;
        //             }
        //             if(rating[i] > rating[j] && rating[j] > rating[k]){
        //                 ans++;
        //             }
                    
        //         }
                
        //     }
            
        // }

        // Prefix Sum

        int pSumRight[] = new int[rating.length];
        int pSumLeft[] = new int[rating.length];

        for(int i=0; i<rating.length; i++){

            for(int j=i; j >= 0; j--){

                if(rating[i] > rating[j]){

                    pSumRight[i]++;
                    ans += pSumRight[j];

                }

                if(rating[i] < rating[j]){

                    pSumLeft[i]++;
                    ans += pSumLeft[j];

                }
                
            }
            
        }

        return ans;
        
    }
}
