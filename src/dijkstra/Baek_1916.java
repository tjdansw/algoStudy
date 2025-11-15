package dijkstra;

import java.util.*;
import java.io.*;

// 1916
public class Baek_1916 {
    static final long MAX_COST = 100_001;
    static int n, m, start, end;
    static long[] minMoveCost;
    static HashMap<Integer, Long>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        minMoveCost = new long[n+1];
        Arrays.fill(minMoveCost, Long.MAX_VALUE);
        graph = new HashMap[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashMap<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long v = Long.parseLong(st.nextToken());
            graph[a].put(b, Math.min(graph[a].getOrDefault(b, MAX_COST),v));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        minMoveCost[start] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Long.compare(minMoveCost[a],minMoveCost[b]));
        pq.add(start);
        while (!pq.isEmpty()){
            int cur = pq.poll();
            for(int next:graph[cur].keySet()){
                long cost = minMoveCost[cur]+graph[cur].get(next);
                if(minMoveCost[next]>cost){
                    minMoveCost[next] = cost;
                    pq.add(next);
                }
            }
        }
        System.out.println(minMoveCost[end]);
    }
}
