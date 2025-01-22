class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m=isWater.length;
        int n=isWater[0].length;

        // Initialize result matrix with same dimensions as input
        int[][] matrix=new int[m][n];

        // Queue to perform BFS
        Queue<int[]> que=new LinkedList<>();


        // Initialize matrix and queue
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(isWater[i][j]==1){
                    // Water cells have height 0 and are added to queue
                    que.add(new int[]{i,j});
                }
                else{
                    // Mark land cells as unvisited (-1)
                    matrix[i][j]=-1;
                }
            }
        }


        // Possible directions: right, left, down, up
        int[][] directions={ {0,1}, {0,-1}, {1,0}, {-1,0} };

        //BFS Traverse
        while(!que.isEmpty()){
            int[] arr=que.poll();
            int r=arr[0];
            int c=arr[1];

            // Check all adjacent cells
            for(int[] dir:directions){
                int nr=r+dir[0];
                int nc=c+dir[1];

                // If adjacent cell is within boundary and unvisited
                if(nr>=0 && nr<m && nc>=0 && nc<n && matrix[nr][nc]==-1){
                    // Set height to 1 more than current cell
                    matrix[nr][nc]=matrix[r][c]+1;  

                    // Add to queue for further exploration
                    que.add(new int[]{nr,nc});      
                } 
            }
        }

        return matrix;
    }
}