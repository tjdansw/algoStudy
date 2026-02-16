package dynamic_programming;

import java.io.*;
import java.util.*;

// 1229
public class Baek_1229 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        ArrayList<Integer> hex = new ArrayList<>();
        for (int i = 1;; i++) {
            int size = 2*i*i - i;
            if(size>n) break;
            hex.add(size);
        }
        final int INF = 1_000_000_000;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int h : hex) {
            for (int i = h; i <= n; i++) {
                if (dp[i - h] + 1 < dp[i]) dp[i] = dp[i - h] + 1;
            }
        }

        System.out.println(dp[n]);
    }
}
