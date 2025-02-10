//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Node {
    int i,j,d;
    Node(int i, int j, int d){
        this.i = i;
        this.j = j;
        this.d = d;
    }
}
class Solution {
    public int[][] nearest(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] vis = new int[m][n];
        int[][] dist = new int[m][n];

        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                if (mat[i][j] == 1){
                    q.offer(new Node(i,j,0));
                    vis[i][j] = 1;
                }
            }
        }

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0,1,0,-1};

        while (!q.isEmpty()){
            Node node = q.poll();
            int r = node.i;
            int c = node.j;
            int dt = node.d;
            dist[r][c] = dt;
            
            for (int counter = 0; counter<4; counter++){
                int nr = r+delrow[counter];
                int nc = c+delcol[counter];

                if (nr>=0 && nc>=0 && nr<m && nc<n && vis[nr][nc] == 0 && mat[nr][nc] == 0){
                    q.offer(new Node(nr, nc, dt+1));
                    vis[nr][nc] = 1;
                }
            }
        }

        return dist;
    }
}