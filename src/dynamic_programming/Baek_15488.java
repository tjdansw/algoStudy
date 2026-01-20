package dynamic_programming;

import java.util.*;
import java.io.*;

// 15488
public class Baek_15488 {
    static int n, x, y, k;
    static final int[] DX = {1, 2, 2, 1, -1, -2, -2, -1};
    static final int[] DY = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        double[][] cur = new double[n + 1][n + 1];
        double[][] next = new double[n + 1][n + 1];

        cur[x][y] = 1.0;

        for (int t = 0; t < k; t++) {
            for (int i = 1; i <= n; i++) Arrays.fill(next[i], 0.0);

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    double p = cur[i][j];
                    if (p == 0.0) continue;

                    double share = p / 8.0;
                    for (int m = 0; m < 8; m++) {
                        int nx = i + DX[m];
                        int ny = j + DY[m];
                        if (inBoard(nx, ny)) {
                            next[nx][ny] += share;
                        }
                    }
                }
            }

            double[][] tmp = cur;
            cur = next;
            next = tmp;
        }

        double ans = 0.0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ans += cur[i][j];
            }
        }

        System.out.printf("%.12f%n", ans);
    }

    static boolean inBoard(int r, int c) {
        return 1 <= r && r <= n && 1 <= c && c <= n;
    }
}
