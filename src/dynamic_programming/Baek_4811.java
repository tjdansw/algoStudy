package dynamic_programming;

import java.io.*;

// 4811
public class Baek_4811 {
    static long[][] dp = new long[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n;
        while ((n = Integer.parseInt(br.readLine()))!=0){
            sb.append(solve(n, 0)).append('\n');
        }
        System.out.println(sb);
    }

    static long solve(int w, int h) {
        if (w == 0) return 1L;
        if (dp[w][h] != 0) return dp[w][h];

        long res = 0;
        res += solve(w - 1, h + 1);
        if (h > 0) res += solve(w, h - 1);
        return dp[w][h] = res;
    }
}

