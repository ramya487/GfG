//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Tuple {
    int i,j,dist;
    Tuple(int i, int j, int dist){
        this.i = i;
        this.j = j;
        this.dist = dist;
    }
}
class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        Queue<Tuple> pq = new LinkedList<>();
        pq.offer(new Tuple(source[0], source[1], 0));
        int m = grid.length; // no of rows
        int n = grid[0].length; // no of cols
        int[][] dist = new int[m][n];
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                dist[i][j] = (int)(1e9);
            }
        }
        dist[source[0]][source[1]] = 0;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        while (!pq.isEmpty()){
            Tuple frnt = pq.poll();
            int row = frnt.i;
            int col = frnt.j;
            int d = frnt.dist;
            for (int i = 0; i<4; i++){
                int nrow = delrow[i]+row;
                int ncol = delcol[i]+col;
                int ndist = d+1;
                if (nrow>=0 && ncol>=0 && nrow<m && ncol<n && grid[nrow][ncol] == 1 && dist[nrow][ncol]>ndist){
                    if (nrow == destination[0] && ncol == destination[1]) return ndist;
                    dist[nrow][ncol] = ndist;
                    pq.offer(new Tuple(nrow, ncol, ndist));
                }
            }
        }
        int distval = dist[destination[0]][destination[1]];
        return (distval == (int)(1e9)) ? -1 : distval;
    }
}
