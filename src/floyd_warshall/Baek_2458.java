package floyd_warshall;

import java.util.*;
import java.io.*;

// 2458
public class Baek_2458 {
    static int n, m;
    static boolean[][] reach;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        reach = new boolean[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            reach[a][b] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (!reach[i][k]) continue;
                for (int j = 1; j <= n; j++) {
                    if (reach[k][j]) reach[i][j] = true;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int out = 0;
            int in = 0;

            for (int j = 1; j <= n; j++) {
                if (reach[i][j]) out++;
                if (reach[j][i]) in++;
            }

            if (in + out == n-1) ans++;
        }

        System.out.println(ans);
    }
}
