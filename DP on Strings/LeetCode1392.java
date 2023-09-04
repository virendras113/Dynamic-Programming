// 1392. Longest Happy Prefix

// Approach - Dynamic Programming (KMP Algorithm)

class Solution {
    public String longestPrefix(String s) {

        int pref[] = helper(s);

        // System.out.println(Arrays.toString(pref));

        int max = 0;

        for(int pre : pref){
            max = Math.max(max, pre);
        }

        return s.substring(0, pref[pref.length-1]);
        
    }

    public static int[] helper(String s){

        int ans[] = new int[s.length()];

        for(int i=1; i<s.length(); i++){

            int j = ans[i-1];

            while(j > 0 && s.charAt(j) != s.charAt(i)){

                j = ans[j-1];

            }

            if(s.charAt(i) == s.charAt(j)){
                j++;
            }

            ans[i] = j;

        }

        return ans;

    }
}
