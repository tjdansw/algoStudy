package dynamic_programming;

import java.util.*;
import java.io.*;

// 11909
public class Baek_11909 {
    static int n;
    static long[][] map, dp;
    static final int[] DX = {1, 0};
    static final int[] DY = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new long[n+2][n+2];
        dp = new long[n+2][n+2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[1][1] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k < 2; k++) {
                    int nx = i + DX[k];
                    int ny = j + DY[k];
                    long pressCount = map[nx][ny] >= map[i][j]?(map[nx][ny] - map[i][j] + 1):0;
                    dp[nx][ny] = Math.min(dp[nx][ny], dp[i][j] + pressCount);
                }
            }
        }
        System.out.println(dp[n][n]);
    }
}
