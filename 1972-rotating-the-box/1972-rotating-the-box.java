class Solution {
    public char[][] rotateTheBox(char[][] box) {
    int m = box.length, n = box[0].length;    
    char ans[][] = new char[n][m];
    for(char d[] : ans)
    Arrays.fill(d, '.');
   

    for(int i=0; i<m; i++)
    {
     int minIndex  = n-1;   
     for(int j=n-1; j>=0; j--)
     {
      if(box[i][j]=='#')
      {
      ans[minIndex][m-i-1] = '#';
      minIndex--;
      }
      if(box[i][j]=='*')
      {
      minIndex = j-1;
      ans[j][m-i-1] = '*';
      }  
     } 
    }
    return ans;
  }
}