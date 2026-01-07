package dynamic_programming;

import java.io.*;
import java.util.*;

// 26259
public class Baek_26259 {
    static int n, m;
    static int[] start = {-1, -1};
    static int[] end = {-1, -1};
    static long[][] map, dp;
    static final int[] DX = {1, 0};
    static final int[] DY = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new long[n + 1][m + 1];
        dp = new long[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        String line = br.readLine();
        if (line != null) {
            st = new StringTokenizer(line);
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            start[0] = Math.min(x1, x2);
            start[1] = Math.min(y1, y2);
            end[0] = Math.max(x1, x2);
            end[1] = Math.max(y1, y2);
        }
        for (int i = 1; i <= n; i++) Arrays.fill(dp[i], Integer.MIN_VALUE);
        dp[1][1] = map[1][1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;

                long best = Integer.MIN_VALUE;

                if (i > 1 && dp[i - 1][j] != Integer.MIN_VALUE && canMove(i - 1, j, i, j)) {
                    best = Math.max(best, dp[i - 1][j]);
                }

                if (j > 1 && dp[i][j - 1] != Integer.MIN_VALUE && canMove(i, j - 1, i, j)) {
                    best = Math.max(best, dp[i][j - 1]);
                }

                if (best != Integer.MIN_VALUE) dp[i][j] = best + map[i][j];
            }
        }

        if (dp[n][m] == Integer.MIN_VALUE) System.out.println("Entity");
        else System.out.println(dp[n][m]);
    }


    static boolean canMove(int sX, int sY, int eX, int eY) {
        if (start[0] == end[0]) { // 가로벽
            if (sX == eX) return true;
            if (!(sX == start[0] && (start[1] < sY && sY <= end[1]))) return true;
        } else { // 세로벽
            if (sY == eY) return true;
            if (!(sY == start[1] && (start[0] < sX && sX <= end[0]))) return true;
        }
        return false;
    }
}
