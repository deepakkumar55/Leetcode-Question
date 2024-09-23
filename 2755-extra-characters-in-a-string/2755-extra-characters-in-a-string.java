class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dictSet = new HashSet<>();
        int sz = s.length();
        for(var word : dictionary){
            dictSet.add(word);
        }
        int delCount[] = new int[sz+1];
        for(int right = 1; right<=sz; right++){
                delCount[right] = 1 + delCount[right-1];
                for(int left = right; left > 0; left--){
                    String word = s.substring(left-1, right);
                    if(dictSet.contains(word)){
                        delCount[right] = Math.min(delCount[right], delCount[left-1]);
                    }
                }
        }
        return delCount[sz];
    }
}