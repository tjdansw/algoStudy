package dynamic_programming;

import java.util.*;
import java.io.*;

// 2281
public class Baek_2281 {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] ps = new int[n + 1];
        for (int i = 1; i <= n; i++) ps[i] = ps[i - 1] + a[i];

        long InF = Long.MAX_VALUE / 4;
        long[] dp = new long[n + 2];
        Arrays.fill(dp, InF);
        dp[n + 1] = 0;

        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                int used = (ps[j] - ps[i - 1]) + (j - i);
                if (used > m) break;

                long cost = (j == n) ? 0L : (long) (m - used) * (m - used);
                dp[i] = Math.min(dp[i], cost + dp[j + 1]);
            }
        }

        System.out.println(dp[1]);
    }
}