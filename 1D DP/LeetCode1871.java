// Jump Game VII

// Approach - Dynamic Programming (Recursion -> Tabulation)

class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        // return recur(s, minJump, maxJump, 0);
        if(s.charAt(s.length()-1) != '0' || s.length() == 0) return false;
        return tabulation(s, minJump, maxJump);
    }
    public static boolean recur(String s, int minJ, int maxJ, int ind){
        if(ind == s.length()-1){
            return true;
        }

        for(int i=minJ; i<=maxJ; i++){
            if(ind + i < s.length() && s.charAt(ind + i) == '0'){
                if(recur(s, minJ, maxJ, ind + i)){
                    return true;
                }
            }
        }

        return false;
    }
    public static boolean tabulation(String s, int minJ, int maxJ){
        boolean tab[] = new boolean[s.length() + 1];

        tab[s.length()-1] = true;

        for(int i=s.length()-2; i>=0; i--){
            if(s.charAt(i) == '0'){
                for(int j=minJ; j<=maxJ; j++){
                    if(i + j < s.length() && tab[i+j] == true){
                        tab[i] = true;
                        break;
                    }
                }
            }
        }

        return tab[0];
    }
}
