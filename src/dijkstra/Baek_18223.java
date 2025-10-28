package dijkstra;

import java.util.*;
import java.io.*;

// 18223
public class Baek_18223 {
    static int v, e, p;
    static int[] minLenOneToV, minLenPToV;
    static ArrayList<Edge>[] graph;

    static class Edge{
        int to;
        int len;

        public Edge(int to, int len) {
            this.to = to;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        graph = new ArrayList[v+1];
        minLenOneToV = new int[v+1];
        minLenPToV = new int[v+1];

        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
            minLenOneToV[i] = Integer.MAX_VALUE;
            minLenPToV[i] = Integer.MAX_VALUE;
        }


        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        minLenOneToV[1] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->Integer.compare(minLenOneToV[a], minLenOneToV[b]));
        pq.add(1);
        while (!pq.isEmpty()){
            int cur = pq.poll();
            if(cur == v){
                continue;
            }

            for(Edge e:graph[cur]){
                int next = e.to;
                int totalLen = e.len+minLenOneToV[cur];
                if(totalLen<minLenOneToV[next]){
                    minLenOneToV[next] = totalLen;
                    pq.add(next);
                }
            }
        }

        minLenPToV[p] = 0;
        pq = new PriorityQueue<>((a, b)->Integer.compare(minLenPToV[a], minLenPToV[b]));
        pq.add(p);
        while (!pq.isEmpty()){
            int cur = pq.poll();
            if(cur == v){
                continue;
            }

            for(Edge e:graph[cur]){
                int next = e.to;
                int totalLen = e.len+minLenPToV[cur];
                if(totalLen<minLenPToV[next]){
                    minLenPToV[next] = totalLen;
                    pq.add(next);
                }
            }
        }
        boolean flag = (minLenOneToV[v]==(minLenOneToV[p]+minLenPToV[v]));
        System.out.println(flag?"SAVE HIM":"GOOD BYE");
    }
}
