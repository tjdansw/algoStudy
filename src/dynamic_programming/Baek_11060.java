package dynamic_programming;

import java.util.*;
import java.io.*;

// 11060
public class Baek_11060 {
    static final int MAX = 2_000;
    static int n;
    static int[] blocks, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        blocks = new int[n+1];
        dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
            dp[i] = MAX;
        }
        dp[1] = 0;
        for (int i = 1; i <= n; i++) {
            int jumpCount = blocks[i];
            for (int j = i+1; j <= i+jumpCount&&j<=n; j++) {
                dp[j] = Math.min(dp[j], dp[i]+1);
            }
        }

        System.out.println(dp[n]==MAX?-1:dp[n]);
    }
}
