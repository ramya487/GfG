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
class Pair {
    int i, j, dist;
    Pair(int i, int j, int dist){
        this.i = i;
        this.j = j;
        this.dist = dist;
    }
}
class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        q.offer(new Pair(source[0], source[1], 0));
        for (int i = 0; i<m ;i++){
            for (int j = 0; j<n; j++){
                dist[i][j] = (int)(1e9);
            }
        }
        dist[source[0]][source[1]] = 0;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        while (!q.isEmpty()){
            Pair frnt = q.poll();
            int r = frnt.i;
            int c = frnt.j;
            int d = frnt.dist;
            for (int counter = 0; counter<4; counter++){
                int nrow = delrow[counter]+r;
                int ncol = delcol[counter]+c;
                int ndist = d+1;
                if (nrow>=0 && ncol >=0 && nrow<m && ncol<n && grid[nrow][ncol] == 1 && dist[nrow][ncol]>ndist){
                    q.offer(new Pair(nrow, ncol, ndist));
                    dist[nrow][ncol] = ndist;
                    if (nrow == destination[0] && ncol == destination[1]){
                        return dist[nrow][ncol];
                    }
                }
            }
        }
        int distance = dist[destination[0]][destination[1]];
        return (distance == (int)(1e9)) ? -1 : distance;
    }
}
