package dynamic_programming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_7579 {
    static StringTokenizer st;
    static StringTokenizer st2;
    static BufferedReader br;

    static int n, m, result = Integer.MAX_VALUE;
    static long[] memory;
    static int[] cost;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_7579.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        memory = new long[n+1];
        cost = new int[n+1];
        dp = new long[n + 1][10001];
        st = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10001; j++) {
                dp[i][j] = dp[i-1][j];
                if (j < cost[i]) continue;
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - cost[i]] + memory[i]);
                if (dp[i][j] >= m) result = Math.min(result, j);
            }
        }
        System.out.println(result);
    }
}
