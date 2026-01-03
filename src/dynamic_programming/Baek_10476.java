package dynamic_programming;

import java.util.*;
import java.io.*;

// 10476
public class Baek_10476 {
    static int n, k;
    static int[][] roomCost;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        roomCost = new int[n+1][2];
        dp = new int[n+1][k+1][3];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            roomCost[i][0] = Integer.parseInt(st.nextToken());
            roomCost[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        dp[0][0][0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i][0][0] = Math.max(dp[i-1][0][0], Math.max(dp[i-1][0][1], dp[i-1][0][2])) + roomCost[i][0]+roomCost[i][1];
            for (int j = 1; j <= k&&j<=i; j++) {
                dp[i][j][0] = Math.max(dp[i-1][j][0], Math.max(dp[i-1][j][1], dp[i-1][j][2])) + roomCost[i][0]+roomCost[i][1];
                dp[i][j][1] = Math.max(dp[i-1][j-1][0], dp[i-1][j-1][1]) + roomCost[i][1];
                dp[i][j][2] = Math.max(dp[i-1][j-1][0], dp[i-1][j-1][2]) + roomCost[i][0];
            }
        }
        System.out.println(Math.max(dp[n][k][0], Math.max(dp[n][k][1], dp[n][k][2])));
    }
}
