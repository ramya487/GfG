//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class DriverClass {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<iPair>> adj = new ArrayList<ArrayList<iPair>>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<iPair>());
            }

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                iPair t1 = new iPair(v, w);
                iPair t2 = new iPair(u, w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }

            int src = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.dijkstra(adj, src);

            for (i = 0; i < V; i++) System.out.print(res.get(i) + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*
class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
*/

class Pair {
    int dist;
    int node;
    Pair(int dist, int node){
        this.dist = dist;
        this.node = node;
    }
}

// User function Template for Java
class Solution {
    // Function to find the shortest distance of all the vertices
    // from the source vertex src.
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int n = adj.size();
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.dist != y.dist ? x.dist - y.dist : x.node - y.node);
        pq.offer(new Pair(0,src));
        
        int[] dist = new int[n];
        Arrays.fill(dist, (int)(1e9));
        
        dist[src] = 0;
        
        while (!pq.isEmpty()){
            Pair frnt = pq.poll();
            int d = frnt.dist;
            int node = frnt.node;
            
            ArrayList<iPair> neigh = adj.get(node);
            int meml = neigh.size();
            
            for (int i = 0; i<meml; i++){
                iPair pair = neigh.get(i);
                int ngh = pair.first;
                int ddist = pair.second;
                
                int ndist = d+ddist;
                if (ndist<dist[ngh]){
                    dist[ngh] = ndist;
                    pq.offer(new Pair(ndist, ngh));
                }
            }
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for (int it: dist){
            ret.add(it);
        }
        return ret;
    }
}