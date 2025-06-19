package graph;

import java.util.*;
import java.io.*;

public class Baek_15591 {
    static int n, q;
    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[a].add(new int[] {b, v});
            graph[b].add(new int[] {a, v});
        }

        int[] visited = new int[n + 1];
        for(int i = 1; i <= q; i++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int root = Integer.parseInt(st.nextToken());
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] {root, Integer.MAX_VALUE});
            visited[root] = i;
            int cnt = 0;
            while(!q.isEmpty()) {
                int[] node = q.poll();
                int current = node[0];
                int value = node[1];
                if(value>=flag){
                    cnt++;
                }
                for(int[] nextNode : graph[current]) {
                    int next = nextNode[0];
                    int len = nextNode[1];
                    if(visited[next]!=i){
                        visited[next] = i;
                        q.add(new int[] {next, Math.min(value, len)});
                    }
                }
            }
            sb.append(cnt-1).append('\n');
        }
        System.out.println(sb);
    }
}
