package dynamic_programming;

import java.util.*;
import java.io.*;

// 1496
public class Baek_1496 {
    static int n;
    static int[] guitars;
    static long[] prefix;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        guitars = new int[2*n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            guitars[i] = Integer.parseInt(st.nextToken());
            guitars[i+n] = guitars[i];
        }

        prefix = new long[2 * n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            prefix[i] = prefix[i - 1] + guitars[i];
        }

        dp = new long[2 * n + 2][2 * n + 2];

        for (int i = 1; i <= 2 * n; i++) {
            dp[i][i] = guitars[i];
        }

        for (int len = 2; len <= n - 1; len++) {
            for (int l = 1; l + len - 1 <= 2 * n; l++) {
                int r = l + len - 1;
                long total = sum(l, r);
                long min = Long.MAX_VALUE;

                for (int k = l; k <= r; k++) {
                    long left = (k > l) ? dp[l][k - 1] : 0;
                    long right = (k < r) ? dp[k + 1][r] : 0;
                    min = Math.min(min, left + right);
                }

                dp[l][r] = total - min;
            }
        }

        long answer = 0;

        for (int i = 1; i <= n; i++) {
            int l = i + 1;
            int r = i + n - 1;

            long remainSum = sum(l, r);
            long opponent = (l <= r) ? dp[l][r] : 0;

            long sejun = guitars[i] + (remainSum - opponent);

            answer = Math.max(answer, sejun);
        }

        System.out.println(answer);
    }

    static long sum(int l, int r) {
        if (l > r) return 0;
        return prefix[r] - prefix[l - 1];
    }
}