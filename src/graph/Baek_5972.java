package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_5972 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, m;
    static ArrayList<Edge>[] list;
    static boolean[] visited;

    static class Edge{
        int next, value;

        public Edge(int next, int value) {
            this.next = next;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));

        pq.add(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            visited[cur[0]] = true;
            if(cur[0] == n){
                System.out.println(cur[1]);
                return;
            }

            for(Edge edge : list[cur[0]]) {
                if(visited[edge.next]) continue;
                int nextVal = edge.value+cur[1];
                pq.add(new int[]{edge.next,nextVal});
            }
        }
    }
}
