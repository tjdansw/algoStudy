package dijkstra;

import java.util.*;
import java.io.*;

// 1939
public class Baek_1939 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer,Integer>[] graph = new HashMap[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashMap<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int value = Math.max(graph[a].getOrDefault(b,0),c);
            graph[a].put(b,value);
            graph[b].put(a,value);
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] weights = new int[n+1];
        boolean[] visited = new boolean[n+1];
        weights[start] = Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1],a[1]));
        pq.add(new int[]{start, Integer.MAX_VALUE});


        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int weight = cur[1];

            if (visited[now]) continue;
            visited[now] = true;

            for (int next : graph[now].keySet()) {
                int edgeWeight = graph[now].get(next);
                int newWeight = Math.min(weight, edgeWeight);

                if (weights[next] < newWeight) {
                    weights[next] = newWeight;
                    pq.offer(new int[]{next, newWeight});
                }
            }
        }
        System.out.println(weights[end]);
    }
}
