public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        int[] count = new int[ratings.length];
        count[0] = 1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i] > ratings[i-1]){
                count[i] = count[i-1] + 1;
            }else{
                count[i] = 1;
            }
        }
        int res = count[ratings.length-1];

        for(int i=ratings.length-1; i >0;i--){
            if(ratings[i-1] > ratings[i] && count[i-1] <= count[i]){
                count[i-1] = count[i] + 1;
            }
            res += count[i-1];
        }

        return res;

    }
}