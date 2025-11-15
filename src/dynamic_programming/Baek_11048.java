package dynamic_programming;

import java.util.*;
import java.io.*;

// 11048
public class Baek_11048 {
    static int n, m;
    static int[][] map, dp;
    static int[] dx = {-1, 0, -1};
    static int[] dy = {0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int max = 0;
                for (int k = 0; k < 3; k++) {
                    int px = i + dx[k];
                    int py = j + dy[k];
                    max = Math.max(max, dp[px][py]);
                }
                dp[i][j] = max + map[i][j];
            }
        }
        System.out.println(dp[n][m]);
    }
}
