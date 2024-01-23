import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> ans=new ArrayList<>();
        List<Integer> ind_a=new ArrayList<>();
        List<Integer> ind_b=new ArrayList<>();
        for(int i=0;i<=s.length()-a.length();i++){
            if(s.substring(i,i+a.length()).equals(a)){
                ind_a.add(i);
            }
        }
        for(int j=0;j<=s.length()-b.length();j++){
            if(s.substring(j,j+b.length()).equals(b)){
                ind_b.add(j);
            }
        }
        for(int i:ind_a){
            for(int j:ind_b){
                if(Math.abs(i-j)<=k){
                    ans.add(i);
                    break;
                }
            }
        }
        ans.sort(null);
        return ans;
    }
} 
    

