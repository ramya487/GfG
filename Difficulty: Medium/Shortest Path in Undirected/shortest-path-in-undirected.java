//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u); // Since the graph is undirected
            }

            int src = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.shortestPath(adj, src);

            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Pair {
    int node;
    int dist;
    Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        Queue<Pair> q = new LinkedList<>();
        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        q.offer(new Pair(src, 0));
        dist[src] = 0;
        while (!q.isEmpty()){
            Pair frnt = q.poll();
            int nd = frnt.node;
            int d = frnt.dist;
            for (int neigh: adj.get(nd)){
                if (dist[neigh] == -1){
                    q.offer(new Pair(neigh, d+1));
                    dist[neigh] = d+1;
                }
            }
        }
        return dist;
    }
}
