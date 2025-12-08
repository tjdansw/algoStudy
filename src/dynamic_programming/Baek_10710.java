package dynamic_programming;

import java.util.*;
import java.io.*;

// 10710
public class Baek_10710 {
    static final int INF = 1_000_000_000;
    static int n, m;
    static int[] loadLen;
    static int[] weatherCost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        loadLen = new int[n+1];
        for (int i = 1; i <= n; i++) {
            loadLen[i] = Integer.parseInt(br.readLine());
        }
        weatherCost = new int[m+1];
        for (int i = 1; i <= m; i++) {
            weatherCost[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int day = 0; day < m; day++) {
            for (int city = 0; city <= n; city++) {
                if (dp[city][day] == INF) continue;

                dp[city][day + 1] = Math.min(dp[city][day + 1], dp[city][day]);

                if (city < n) {
                    int cost = loadLen[city + 1] * weatherCost[day + 1];
                    dp[city + 1][day + 1] = Math.min(dp[city + 1][day + 1], dp[city][day] + cost);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
