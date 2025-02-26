package dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_9251 {
    static BufferedReader br;

    static String str1, str2;
    static int n,m;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();
        n = str1.length();
        m = str2.length();

        dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
