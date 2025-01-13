class Solution {
    public int minimumLength(String s) {        
        int[] arr=new int[26];

        //Counting the char
        for(char ch:s.toCharArray()){
            arr[ch-'a']++;
        }

        //Applying the rules
        for(int i=0; i<26; i++){
            while(arr[i]>=3){
                arr[i]-=2;
            }
        }
        
        int len=0;
        //Counting the length of final string
        for(int i=0; i<26; i++){
            len+=arr[i];
        }        

        return len;
    }
}