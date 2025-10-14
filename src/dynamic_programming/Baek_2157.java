package dynamic_programming;

import java.util.*;
import java.io.*;

// 2157
public class Baek_2157 {
    static int n, m, k;
    static HashMap<Integer, Integer>[] graph;
    static int[][] dp;

    static class PlaneInfo {
        int to, foodScore;

        public PlaneInfo(int to, int foodScore) {
            this.to = to;
            this.foodScore = foodScore;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new HashMap[n+1];
        dp = new int[m+1][n+1];
        for (int i = 1; i <= n; i++) graph[i] = new HashMap<>();
        for (int i = 1; i <= m; i++) Arrays.fill(dp[i], -1);

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a>b){
                continue;
            }
            graph[a].put(b, Math.max(graph[a].getOrDefault(b, 0 ), c));
        }

        int max = 0;
        dp[1][1] = 0;
        for (int i = 1; i <m; i++) {
            for (int j = i; j <= n; j++) {
                if(dp[i][j] == -1) continue;
                for(int next:graph[j].keySet()){
                    int foodScore = graph[j].get(next);
                    dp[i+1][next] = Math.max(dp[i+1][next], dp[i][j]+foodScore);
                }
            }
        }

        for (int i = 1; i <= m ; i++) max = Math.max(max, dp[i][n]);
        System.out.println(max);
    }
}
