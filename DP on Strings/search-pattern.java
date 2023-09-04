// Search Pattern

// Approach - Dynamic Programming (KMP Algorithm)

class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        ArrayList<Integer> res = new ArrayList<>();
        
        int pref[] = helper(pat + "#" + txt);
        
        // System.out.println(Arrays.toString(pref));
        
        for(int i=0; i<pref.length; i++){
            
            if(pref[i] == pat.length()){
                res.add(i - pat.length() - pat.length() + 1);
            }
            
        }
        
        return res;
    }
    
    public static int[] helper(String s){
        
        int ans[] = new int[s.length()];
        
        for(int i=1; i<ans.length; i++){
            
            int j = ans[i-1];
            
            while(j > 0 && s.charAt(i) != s.charAt(j)){
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
