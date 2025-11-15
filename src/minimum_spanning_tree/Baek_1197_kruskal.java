package minimum_spanning_tree;

import java.util.*;
import java.io.*;

// 1197
public class Baek_1197_kruskal {
    static int v, e;
    static ArrayList<Edge> edges = new ArrayList<>();
    static int[] parent;

    static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) parent[i] = i;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        Collections.sort(edges, (a, b) -> Integer.compare(a.cost, b.cost));

        long total = 0;
        int selected = 0;

        for (Edge edge : edges) {
            if (union(edge.from, edge.to)) {
                total += edge.cost;
                selected++;
                if (selected == v - 1) break;
            }
        }

        System.out.println(total);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return false;

        parent[pb] = pa;
        return true;
    }
}
