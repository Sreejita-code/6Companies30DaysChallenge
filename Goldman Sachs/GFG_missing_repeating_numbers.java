class Solve {
    int[] findTwoElement(int arr[], int n) {
        int[] result=new int[2];
        int[] temp=new int[n];
        for(int i=0;i<n;i++){
            temp[arr[i]-1]++;
        }
        for(int i=0;i<n;i++){
            if(temp[i]==2){
                result[0]=i+1;
            }
            if(temp[i]==0){
                result[1]=i+1;
            }
        }
        return result;
    }
}
