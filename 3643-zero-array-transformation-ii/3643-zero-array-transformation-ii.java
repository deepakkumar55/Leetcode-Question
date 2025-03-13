class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length ; 
        int m = queries.length ; 
        int curr = 0 ; 
        while( curr<n && nums[curr] == 0 ) curr++ ; 
        if( curr == n ) return 0 ; 
        int[] diff = new int[n+1] ; 
        diff[0] = nums[0] ; 
        for( int i=1 ; i<n ; ++i ){
            diff[i] = nums[i] - nums[i-1] ; 
        }
        int l ,r ,val ; 
        for( int i=0 ; i<m ; ++i ){
            l = queries[i][0] ; 
            r = queries[i][1] ; 
            val = queries[i][2] ; 
            if( l > curr){
                diff[l] -= val ;
                diff[r+1] += val ; 
            }else if( r >= curr ){
                diff[curr] -= val ; 
                diff[r+1] += val ;
            }
            if( diff[curr] <= 0 ){
                while( curr < n && diff[curr] <= 0 ){
                    if(++curr < n ){
                        diff[curr] += diff[curr-1] ; 
                    }
                }
                if( curr == n ) return i+1 ; 
            }
        }
        return -1 ; 
    }
}