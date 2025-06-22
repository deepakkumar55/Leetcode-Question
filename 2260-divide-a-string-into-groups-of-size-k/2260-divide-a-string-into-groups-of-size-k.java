class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len = s.length();
        int groupCount = (len+k-1)/k;
        String[] result = new String[groupCount];

        for(int i =0; i<groupCount; i++){
            int start = i *k;
            int end = Math.min(start+k,len);
            String part = s.substring(start, end);

            if(part.length()<k){
                StringBuilder sb = new StringBuilder(part);
                for(int j=0; j<k-part.length(); j++){
                    sb.append(fill);
                }
                part= sb.toString();
            }
            result[i]=part;

        }
        return result;
    }
}