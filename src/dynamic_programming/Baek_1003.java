package dynamic_programming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Baek_1003 {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static long[][] dp = new long[41][2];

    static {
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i = 2; i < 41; i++){
            dp[i][0] = dp[i-2][0] + dp[i-1][0];
            dp[i][1] = dp[i-2][1] + dp[i-1][1];
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_1003.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num][0]).append(" ").append(dp[num][1]).append('\n');
        }
        System.out.println(sb);
    }
}
