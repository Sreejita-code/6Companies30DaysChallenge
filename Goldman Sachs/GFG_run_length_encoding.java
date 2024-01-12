class GfG
 {
	String encode(String str)
	{
        int count=1;
        String str1="";
        for(int i=0;i<str.length();i++){
            str1+=str.charAt(i);
            count=1;
            while(i+1<str.length()&& str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            str1+=count+"";
        }
        return str1;
            
            
	}
	
 }
