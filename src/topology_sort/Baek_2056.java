package topology_sort;

import java.util.*;
import java.io.*;

// 2056
public class Baek_2056 {
    static int n;
    static int[] time, indegree, dp;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        time = new int[n+1];
        indegree = new int[n+1];
        dp = new int[n+1];
        graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int pre = Integer.parseInt(st.nextToken());
                graph[pre].add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            dp[i] = time[i];
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                dp[next] = Math.max(dp[next], dp[now] + time[next]);
                if (--indegree[next] == 0) q.add(next);
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
