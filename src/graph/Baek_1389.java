package graph;

import java.util.*;
import java.io.*;

// 1389
public class Baek_1389 {
    static int n, m;
    static HashSet<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new HashSet[n+1];
        for (int i = 1; i < n+1; i++) {
            graph[i] = new HashSet<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        int min = Integer.MAX_VALUE;
        int idx = 0;

        for (int i = 1; i < n+1; i++) {
            Queue<int[]> q = new LinkedList<>();
            boolean[] visited = new boolean[n+1];
            q.add(new int[]{i, 0});
            visited[i] = true;
            int res = 0;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int node = cur[0];
                int cnt = cur[1];
                for(int next : graph[node]) {
                    if(!visited[next]) {
                        visited[next] = true;
                        res += cnt+1;
                        q.add(new int[]{next, cnt+1});
                    }
                }
            }
            if(min > res){
                min = res;
                idx = i;
            }
        }
        System.out.println(idx);

    }
}

/**
 * 플로이 워셜
 * import java.io.*;
 * import java.util.*;
 *
 * public class Main {
 *     static final int INF = 1000000000;
 *
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         StringTokenizer st = new StringTokenizer(br.readLine());
 *
 *         int n = Integer.parseInt(st.nextToken());
 *         int m = Integer.parseInt(st.nextToken());
 *
 *         int[][] dist = new int[n + 1][n + 1];
 *
 *         for (int i = 1; i <= n; i++) {
 *             Arrays.fill(dist[i], INF);
 *             dist[i][i] = 0;
 *         }
 *
 *         for (int i = 0; i < m; i++) {
 *             st = new StringTokenizer(br.readLine());
 *             int a = Integer.parseInt(st.nextToken());
 *             int b = Integer.parseInt(st.nextToken());
 *
 *             dist[a][b] = 1;
 *             dist[b][a] = 1;
 *         }
 *
 *         for (int k = 1; k <= n; k++) {
 *             for (int i = 1; i <= n; i++) {
 *                 for (int j = 1; j <= n; j++) {
 *                     if (dist[i][j] > dist[i][k] + dist[k][j]) {
 *                         dist[i][j] = dist[i][k] + dist[k][j];
 *                     }
 *                 }
 *             }
 *         }
 *
 *         int answer = 0;
 *         int min = Integer.MAX_VALUE;
 *
 *         for (int i = 1; i <= n; i++) {
 *             int sum = 0;
 *             for (int j = 1; j <= n; j++) {
 *                 sum += dist[i][j];
 *             }
 *
 *             if (sum < min) {
 *                 min = sum;
 *                 answer = i;
 *             }
 *         }
 *
 *         System.out.println(answer);
 *     }
 * }
 */