package dynamic_programming;

import java.util.*;
import java.io.*;

// 30621
public class Baek_30621 {
    static int n;
    static long[] ts, bs, cs, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ts = new long[n+1];
        bs = new long[n+1];
        cs = new long[n+1];
        dp = new long[n+1];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            ts[i] = Long.parseLong(st1.nextToken());
            bs[i] = Long.parseLong(st2.nextToken());
            cs[i] = Long.parseLong(st3.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            long limit = ts[i] - bs[i];

            int l = 1, r = i - 1;
            int ans = 0;
            while (l <= r) {
                int mid = (l + r)/2;
                if (ts[mid] < limit) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            dp[i] = Math.max(dp[i - 1], dp[ans] + cs[i]);
        }

        System.out.println(dp[n]);
    }
}
