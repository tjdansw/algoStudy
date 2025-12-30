package dynamic_programming;

import java.util.*;
import java.io.*;

// 17953
public class Baek_17953 {
    static int n, m;
    static int[][] desserts, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        desserts = new int[m][n];
        dp = new int[m][n];
        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                desserts[j][i] = Integer.parseInt(st.nextToken());
            }
            dp[j][0] = desserts[j][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    int satisfaction = dp[k][i-1] + (j==k?desserts[j][i]/2:desserts[j][i]);
                    dp[j][i] = Math.max(dp[j][i], satisfaction);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, dp[i][n-1]);
        }
        System.out.println(max);
    }
}
