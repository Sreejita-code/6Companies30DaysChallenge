package Adobe;

class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] result = new int[rows* cols][];
        result[0] = new int[] {rCenter, cCenter};            
        int resultIdx = 1;
        int lim = Math.max( rCenter, rows-rCenter-1 ) + Math.max( cCenter, cols-cCenter-1 );
		                                           
        for (int dist = 1; dist <= lim; dist++) {  
            int r = rCenter - dist;
            int c = cCenter;
            
            for (int count = dist; count > 0; count--) {    
                if (r >= 0 && c >= 0)  result[resultIdx++] = new int[] {r, c};
                r++;
                c--;
            }
            
            
            for (int count = dist; count > 0; count--) {
                if (r < rows && c >= 0)  result[resultIdx++] = new int[] {r, c};
                r++;
                c++;
            }
            
            
            for (int count = dist; count > 0; count--) {
                if (r < rows && c < cols)  result[resultIdx++] = new int[] {r, c};
                r--;
                c++;
            }
            
           
            for (int count = dist; count > 0; count--) {
                if (r >= 0 && c < cols)  result[resultIdx++] = new int[] {r, c};
                r--;
                c--;
            }
        }
        return result;
    }
}
