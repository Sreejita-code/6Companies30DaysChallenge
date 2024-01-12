class DataStream {
    int val,n,count;
    public DataStream(int value, int k) {
        this.val=value;
        this.n=k;
        this.count=0;    
    }
    
    public boolean consec(int num) {
        if(num==val){
            count++;
        }
        else{
            count=0;
            return false;
        }
        if(count==n){
            count=n-1;
            return true;
        }
        return false;
    }
}
