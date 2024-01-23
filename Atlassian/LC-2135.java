import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        int count=0;
        Set<String> set=new HashSet<>();
        for(String start:startWords){
            char[] s=start.toCharArray();
            Arrays.sort(s);
            set.add(new String(s));
        }
        int m=targetWords.length;
        for(int i=0;i<m;i++){
            char[] t=targetWords[i].toCharArray();
            Arrays.sort(t);
            int k=t.length;
            String str=String.valueOf(t);
            for(int j=0;j<k;j++){
                String str1=str.substring(0,j)+str.substring(j+1);
                if(set.contains(str1)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
