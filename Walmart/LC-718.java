package Walmart;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
       int len1 = nums1.length;
        int len2 = nums2.length;
        int len_12 = Math.max(len1,len2);

        long[] p = new long[len_12];
        long[] h1 = new long[len1];
        long[] h2 = new long[len2];
        int P = 1313131;
        p[0] = 1;
        h1[0] = nums1[0];
        h2[0] = nums2[0];

        for(int i=1;i<len_12;i++) p[i] = p[i-1] * P;
        for(int i=1;i<len1;i++) h1[i] = h1[i-1]*P+nums1[i];
        for(int i=1;i<len2;i++) h2[i] = h2[i-1]*P+nums2[i];
        
        int lo = 1;
        int hi = Math.min(len1,len2);
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(check(nums1,nums2,mid,p,h1,h2)) lo = mid + 1;
            else hi = mid - 1;
        }
        return hi;
    }
    public boolean check(int[] nums1, int[] nums2, int l, long[] p, long[] h1, long[] h2){
        Set<Long> set = new HashSet<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        set.add(h1[l-1]);
        for(int i=1;i<=len1-l;i++){
            long tmp = h1[i+l-1]-h1[i-1]*p[l];
            set.add(tmp);
        }
        if(set.contains(h2[l-1])) return true;
        for(int i=1;i<=len2-l;i++){
            long tmp = h2[i+l-1]-h2[i-1]*p[l];
            if(set.contains(tmp)) return true;
        }
        return false; 
    }
}
