package minimum_spanning_tree;

import java.util.*;
import java.io.*;

// 1197
public class Baek_1197_Prim {
    static final int MAX = 1_000_000;
    static int v, e;
    static HashMap<Integer, Integer>[] graph;

    static class Edge{
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        graph = new HashMap[v+1];
        for (int i = 1; i <= v; i++) graph[i] = new HashMap<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].put(b, Math.min(graph[a].getOrDefault(b, MAX), c));
            graph[b].put(a, Math.min(graph[b].getOrDefault(a, MAX), c));
        }

        boolean[] isVisited = new boolean[v+1];
        int total = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b)->Integer.compare(a.cost, b.cost));
        pq.add(new Edge(1, 0));
        while (!pq.isEmpty()){
            Edge e = pq.poll();
            int cur = e.to;
            int cost = e.cost;

            if(isVisited[cur]) continue;
            isVisited[cur] = true;
            total += cost;

            for(int next:graph[cur].keySet()){
                if(!isVisited[next]){
                    pq.add(new Edge(next, graph[cur].get(next)));
                }
            }
        }
        System.out.println(total);
    }
}
