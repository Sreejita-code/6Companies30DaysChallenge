package Walmart;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    static long MOD = (long)(1e9+7);
    public int squareFreeSubsets(int[] nums) {
         int[] primes = new int[]{2,3,5,7,11,13,17,19,23,29};
        int[] nonSq = new int[]{4,8,9,12,16,18,20,24,25,27,28};
        products=new long[1024];
        index=0;

        rec(primes, 0, new HashSet<>());
        Arrays.sort(products);
        Arrays.sort(nums);
        
        Map<Long, Long> cntMap = new HashMap<>();
        for(long ele: products) 
        {
            cntMap.put(ele, 0L);
        }
        cntMap.put(1L, 1L);
        long ans=0;
        int n=nums.length;

        for(int i=0;i<n;++i)
        {
            int ele=nums[i];
            boolean isNonSq = false;
            for(int x: nonSq)
                if(x==ele)
                    isNonSq = true;
            
            if(isNonSq)
                continue;
                
            for(long x: products)
            {
                if(x<ele)
                    continue;
                else if(x%ele==0)
                {
                    long y=x/ele;
                    if(cntMap.get(y)!=0) 
                    {
                        ans=(ans+cntMap.get(y))%MOD;
                        cntMap.put(x, (cntMap.get(x)+cntMap.get(y))%MOD);
                    }
                    
                }
            }

        }
        return (int)(ans%MOD);
    }
    static long[] products;
    static int index;
    public void rec(int[] primes, int idx, Set<Integer> set)
    {
        if(idx==primes.length)
        {
            long pro =1;
            for(int x: set)
            {
                pro=pro*x;
            }
            products[index] = pro;
            index++;
            return;
        }

        set.add(primes[idx]);
        rec(primes, idx+1, set);
        set.remove(primes[idx]);

        rec(primes, idx+1, set);
    }
}
