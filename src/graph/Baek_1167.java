package graph;

import java.io.*;
import java.util.*;

// 1167
public class Baek_1167 {
    static int n;
    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        for(int i = 1;i<=n;i++){
            graph[i] = new ArrayList<int[]>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end;
            while((end=Integer.parseInt(st.nextToken()))!=-1){
                int value = Integer.parseInt(st.nextToken());
                graph[start].add(new int[]{end,value});
            }
        }

        int[] nodeInfo = bfs(1);

        System.out.println(bfs(nodeInfo[0])[1]);
    }

    private static int[] bfs(int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        visited[start] = true;

        int maxDist = 0;
        int maxNode = start;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int dist = cur[1];

            if (dist > maxDist) {
                maxDist = dist;
                maxNode = node;
            }

            for (int[] next : graph[node]) {
                int nextNode = next[0];
                int nextDist = next[1];
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    q.add(new int[]{nextNode, dist + nextDist});
                }
            }
        }

        return new int[]{maxNode, maxDist};
    }
}
