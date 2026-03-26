package dynamic_programming;

import java.util.*;
import java.io.*;

// 2169
public class Baek_2169 {
    static int n, m;
    static final int MIN = -200_000;
    static int[][] map, dp;
    static final int[] DX = {0, 1, 0};
    static final int[] DY = {-1, 0, 1};

    static class State{
        int x, y, prevDir, value;

        public State(int x, int y, int prevDir, int value) {
            this.x = x;
            this.y = y;
            this.prevDir = prevDir;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = MIN;
            }
        }

        dp[0][0] = map[0][0];
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + map[0][j];
        }

        for (int i = 1; i < n; i++) {
            int[] left = new int[m];
            int[] right = new int[m];

            left[0] = dp[i - 1][0] + map[i][0];
            for (int j = 1; j < m; j++) {
                left[j] = Math.max(dp[i - 1][j], left[j - 1]) + map[i][j];
            }

            right[m - 1] = dp[i - 1][m - 1] + map[i][m - 1];
            for (int j = m - 2; j >= 0; j--) {
                right[j] = Math.max(dp[i - 1][j], right[j + 1]) + map[i][j];
            }

            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }

        System.out.println(dp[n - 1][m - 1]);
    }

    static boolean isBound(int x, int y){
        return 0<=x&&x<n&&0<=y&&y<m;
    }
}
