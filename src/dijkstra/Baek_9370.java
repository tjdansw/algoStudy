package dijkstra;

import java.util.*;
import java.io.*;

// 9370
public class Baek_9370 {
    static int n, m, t;
    static int s, g, h;
    static int[] dist;
    static boolean[] isVisited;
    static ArrayList<Edge>[] graph;

    static class Edge{
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            init();
            dist[s] = 0;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                graph[a].add(new Edge(b, d));
                graph[b].add(new Edge(a, d));
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>((a, b)->Integer.compare(a.cost, b.cost));
            pq.add(new Edge(s,0));
            while (!pq.isEmpty()){
                Edge edge = pq.poll();
                int current = edge.to;
                int currentCost = edge.cost;

                if (currentCost > dist[current]) continue;

                for(Edge e:graph[current]){
                    int next = e.to;
                    int cost = currentCost + e.cost;
                    boolean visitedCheck = isVisited[current]
                            || (current == g && next == h)
                            || (current == h && next == g);

                    if(dist[next]>cost){
                        dist[next] = cost;
                        isVisited[next] = visitedCheck;
                        pq.add(new Edge(next, cost));
                    }else if(dist[next] == cost){
                        if (visitedCheck && !isVisited[next]) {
                            isVisited[next] = true;
                            pq.add(new Edge(next, cost));
                        }
                    }
                }
            }
            ArrayList<Integer> destinations = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                int node = Integer.parseInt(br.readLine());
                if(isVisited[node]){
                    destinations.add(node);
                }
            }
            Collections.sort(destinations);
            for(int node:destinations) sb.append(node).append(' ');
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void init(){
        dist = new int[n+1];
        isVisited = new boolean[n+1];
        graph = new ArrayList[n+1];
        for(int i = 1;i<=n;i++){
            dist[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }
    }
}
