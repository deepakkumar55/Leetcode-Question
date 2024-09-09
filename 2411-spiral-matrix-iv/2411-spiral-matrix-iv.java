class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        int mat[][] = new int[m][n];
        
        ListNode curr = head;
        int noOfCells = 0;
        
        while (curr != null || noOfCells < m * n) {

            for (int c = left; c <= right && isSafe(left, right, top, bottom); c++) {
                int val = -1;
                if (curr != null) {
                    val = curr.val;
                    curr = curr.next;
                }
                mat[top][c] = val;
                noOfCells++;
            }
            top++;
            
   
            for (int r = top; r <= bottom && isSafe(left, right, top, bottom); r++) {
                int val = -1;
                if (curr != null) {
                    val = curr.val;
                    curr = curr.next;
                }
                mat[r][right] = val;
                noOfCells++;
            }
            right--;
            
     
            for (int c = right; c >= left && isSafe(left, right, top, bottom); c--) {
                int val = -1;
                if (curr != null) {
                    val = curr.val;
                    curr = curr.next;
                }
                mat[bottom][c] = val;
                noOfCells++;
            }
            bottom--;
            
    
            for (int r = bottom; r >= top && isSafe(left, right, top, bottom); r--) {
                int val = -1;
                if (curr != null) {
                    val = curr.val;
                    curr = curr.next;
                }
                mat[r][left] = val;
                noOfCells++;
            }
            left++;
        }
        
        return mat;
    }
    private boolean isSafe(int left, int right, int top, int bottom){
        return left <= right && bottom >= top;
    }
}