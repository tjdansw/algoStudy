package dynamic_programming;

import java.io.*;
import java.util.*;

// 25759
public class Baek_25759 {
    static int n;
    static int[] flowers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        flowers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            flowers[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[101];
        Arrays.fill(dp, Integer.MIN_VALUE);
        
        long answer = 0;
        for (int i = 0; i < n; i++) {
            for (int v = 1; v <= 100; v++) {
                if(dp[v]==Integer.MIN_VALUE) continue;
                long term = flowers[i] - v;
                long value = dp[v] + term*term;
                dp[flowers[i]] = Math.max(dp[flowers[i]], value);
            }
            dp[flowers[i]] = Math.max(dp[flowers[i]], 0);
            answer = Math.max(dp[flowers[i]], answer);
        }
        System.out.println(answer);
    }
}
