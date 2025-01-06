class Solution {
    public int[] minOperations(String boxes) {
        int n =  boxes.length();
        int suffix[] =  new int[n];
        int prefix[] =  new int[n];
        int count1=0;
        if(boxes.charAt(0)=='1') count1++;
        for(int i=1;i<n;i++ ){
            prefix[i] =  prefix[i-1]+count1;
            
            if(boxes.charAt(i)=='1') count1++;
        }
        count1=0;
        if(boxes.charAt(n-1)=='1') count1++;
        for(int i=n-2;i>=0;i--){
            suffix[i] = suffix[i+1]+count1;
            if(boxes.charAt(i)=='1') count1++;
        }
        
        int ans[] =  new int[n];
        for(int i=0;i<n;i++){
            ans[i]=  prefix[i]+suffix[i];
        }
        return ans;
    }
}