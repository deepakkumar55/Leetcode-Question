class Solution {
    int[] xDir = {0,0,-1,1};
    int[] yDir = {-1,1,0,0};
    public int DFS(int[][] grid,int i,int j,int var)
    {
        grid[i][j] = var;
        int count = 1;
        for(int k = 0;k<4;k++)
        {
            int newRow = i+xDir[k];
            int newCol = j+yDir[k];
            if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && grid[newRow][newCol] == 1)
            {
                count+=DFS(grid,newRow,newCol,var);
            }
        }
        return count;
    }
    public int largestIsland(int[][] grid) {
        int islands = 0;
        int var = -1;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i = 0;i<grid.length;i++)
        {
            for(int j = 0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 1)
                {
                    int area = DFS(grid,i,j,var);
                    hmap.put(var,area);
                    var--;
                }
            }
        }
        boolean zero = false;
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0;i<grid.length;i++)
        {
            for(int j = 0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 0)
                {
                    zero = true;
                    HashSet<Integer> hset = new HashSet<>();
                    int area = 1;
                    for(int k = 0;k<4;k++)
                    {
                        int newRow = i+xDir[k];
                        int newCol = j+yDir[k];
                        if(newRow >= 0 && newRow<grid.length && newCol >= 0 && newCol<grid[0].length)
                        {
                            hset.add(grid[newRow][newCol]);
                        }
                    }
                    for(int item : hset)
                    {
                        if(item != 0)
                            area += hmap.get(item);
                    }
                    maxArea = Math.max(maxArea,area);
                }
            }   
        }
        return (zero == true)?maxArea:hmap.get(-1);
    }
}