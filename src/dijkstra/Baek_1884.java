package dijkstra;

import java.util.*;
import java.io.*;

// 1884
public class Baek_1884 {
    static int k, n, r, minLen = Integer.MAX_VALUE;
    static ArrayList<Edge>[] graph;
    static int[][] dist;
    static int[] minimumLen;

    static class Edge{
        int arrive, len, cost;

        public Edge(int arrive, int len, int cost) {
            this.arrive = arrive;
            this.len = len;
            this.cost = cost;
        }
    }

    static class State {
        int node, len, cost;

        public State(int node, int len, int cost) {
            this.node = node;
            this.len = len;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        r = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        dist = new int[n+1][k+1]; // dist[i][j] : j 비용으로 i까지 도달할 때까지 최소 길이
        for (int i = 1; i < n+1; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[1][0] = 0;

        for (int i = 0; i < r; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[s].add(new Edge(d, l, t));
        }

        PriorityQueue<State> pq = new PriorityQueue<>((a, b)->Integer.compare(a.len, b.len));
        pq.add(new State(1, 0, 0));
        while (!pq.isEmpty()) {
            State state = pq.poll();
            int cur = state.node;
            int cost = state.cost;
            int len = state.len;

            if(len != dist[cur][cost]) continue;
            if(cur == n){
                System.out.println(len);
                return;
            }

            for(Edge edge : graph[cur]) {
                int nextCost = edge.cost + cost;
                if(nextCost>k) continue;

                int nextLen = edge.len + len;
                if(nextLen<dist[edge.arrive][nextCost]) {
                    dist[edge.arrive][nextCost] = nextLen;
                    pq.add(new State(edge.arrive, nextLen, nextCost));
                }
            }
        }
        System.out.println(-1);
    }

}
