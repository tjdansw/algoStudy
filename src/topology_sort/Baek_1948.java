package topology_sort;

import java.util.*;
import java.io.*;

// 1948
public class Baek_1948 {
    static int n, m, start, end;
    static ArrayList<Edge>[] graph;
    static ArrayList<Edge>[] revGraph;
    static int[] indegree;
    static int[] dist;

    static class Edge {
        int to, time;

        public Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        revGraph = new ArrayList[n + 1];
        indegree = new int[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            revGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            revGraph[b].add(new Edge(a, c));
            indegree[b]++;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Edge next : graph[cur]) {
                int nxt = next.to;
                int w = next.time;

                if (dist[nxt] < dist[cur] + w) {
                    dist[nxt] = dist[cur] + w;
                }

                indegree[nxt]--;
                if (indegree[nxt] == 0) {
                    q.add(nxt);
                }
            }
        }
        int totalArriveTime = dist[end];


        int cnt = 0;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> rq = new LinkedList<>();
        rq.add(end);
        visited[end] = true;

        while (!rq.isEmpty()) {
            int cur = rq.poll();

            for (Edge prev : revGraph[cur]) {   // prev.to -> cur
                int preNode = prev.to;
                int w = prev.time;

                if (dist[preNode] + w == dist[cur]) {
                    cnt++;

                    if (!visited[preNode]) {
                        visited[preNode] = true;
                        rq.add(preNode);
                    }
                }
            }
        }
        System.out.println(totalArriveTime);
        System.out.println(cnt);
    }
}
