package Walmart;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> mpp=new HashMap<>();
        for(int i:nums){
            mpp.put(i,mpp.getOrDefault(i,0)+1);
        }
        int result=0;
        for(int i:mpp.keySet()){
            if(k>0 && mpp.containsKey(i+k) || k==0 && mpp.get(i)>1){
                result++;
            }
        }
        return result;
    }
}
