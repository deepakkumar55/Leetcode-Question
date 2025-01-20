class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;

        int[] rowFeq=new int[m]; 
        int[] colFeq=new int[n]; 

        Map<Integer, int[]> map=new HashMap<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                map.put(mat[i][j], new int[]{i,j});
            }
        }
        
        for(int i=0; i<arr.length; i++){
            int[] idx=map.get(arr[i]);
            int r=idx[0];
            int c=idx[1];

            rowFeq[r]++;
            colFeq[c]++;

            if(rowFeq[r]==n || colFeq[c]==m){ 
                return i;
            }
        }

        return -1;
    }

}