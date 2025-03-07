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

class Pair{
    int n,d;
    Pair(int n, int d){
        this.d = d;
        this.n = n;
    }
}

// User function Template for Java
class Solution {
    // Function to find the shortest distance of all the vertices
    // from the source vertex src.
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int siz = adj.size();
        int[] dist = new int[siz];
        Arrays.fill(dist, (int)(1e9));
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.d != y.d ? x.d - y.d : x.n - y.n);
        pq.offer(new Pair(src,0));
        dist[src] = 0;
        while (!pq.isEmpty()){
            Pair frnt = pq.poll();
            int n = frnt.n;
            int d = frnt.d;
            for (iPair neigh: adj.get(n)){
                int dis = neigh.second;
                int node = neigh.first;
                if (dis+d < dist[node]){
                    dist[node] = dis+d;
                    pq.offer(new Pair(node, dis+d));
                }
            }
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for (int itr: dist){
            ret.add(itr);
        }
        return ret;
        
    }
}