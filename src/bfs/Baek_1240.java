package bfs;

import java.util.*;
import java.io.*;

// 1240
public class Baek_1240 {
    static int n, m;
    static ArrayList<Edge>[] graph;

    static class Edge{
        int to, len;

        public Edge(int to, int len) {
            this.to = to;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++)graph[i] = new ArrayList<>();

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boolean flag = true;

            Queue<Edge> q = new LinkedList<>();
            q.add(new Edge(a,0));
            boolean[] visited = new boolean[n+1];
            visited[a] = true;
            while (!q.isEmpty()&&flag){
                Edge e = q.poll();
                int cur = e.to;
                int len = e.len;
                for(Edge node:graph[cur]) {
                    int next = node.to;
                    int nextLen = len + node.len;
                    if(visited[next]) continue;
                    if(next == b){
                        sb.append(nextLen).append('\n');
                        flag = false;
                        break;
                    }
                    visited[next] = true;
                    q.add(new Edge(next, nextLen));
                }
            }
        }

        System.out.println(sb);
    }
}
