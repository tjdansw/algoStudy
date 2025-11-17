package minimum_spanning_tree;

import java.util.*;
import java.io.*;

// 1922
// kruskal
public class Baek_1922 {
    static int n, m;
    static ArrayList<Edge> edges;
    static int[] parent;

    static class Edge{
        int from, to, cost;

        public Edge(int form, int to, int cost) {
            this.from = form;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        edges = new ArrayList<>();
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==b) continue;
            edges.add(new Edge(a, b, c));
        }
        Collections.sort(edges, (a,b)->Integer.compare(a.cost, b.cost));

        int totalConnectionCost = 0;
        for(Edge e: edges){
            int a = e.from;
            int b = e.to;
            int cost = e.cost;

            if(union(a, b)){
                totalConnectionCost += cost;
            }
        }
        System.out.println(totalConnectionCost);
    }

    static int findParent(int x){
        if(parent[x]==x) return x;
        return parent[x] = findParent(parent[x]);
    }

    static boolean union(int x, int y){
        int parentX = findParent(x);
        int parentY = findParent(y);

        if(parentX==parentY) return false;
        parent[parentY] = parentX;
        return true;
    }
}
