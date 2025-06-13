package dynamic_programming;

import java.io.*;
import java.util.StringTokenizer;

// 2240
public class Baek_2240 {
    static int t, w, max=0;
    static int[] time = new int[1001];
    static int[][][] dp = new int[2][1001][32];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= t; i++) {
            time[i] = Integer.parseInt(br.readLine())-1;
        }

        if (time[1] == 0) {
            dp[0][1][0] = 1;
        } else {
            dp[1][1][1] = 1;
        }

        for (int i = 2; i <= t; i++) {
            int p = time[i];
            dp[p][i][0] = dp[p][i-1][0]+1;
            for (int j = 1; j <= w+1; j++) {
                dp[p][i][j] = Math.max(dp[p][i-1][j], dp[1-p][i-1][j-1])+1;
                dp[1-p][i][j] = Math.max(dp[1-p][i-1][j], dp[p][i-1][j-1]);
            }
        }

        int max = 0;
        for (int i = 0; i <= w; i++) {
            max = Math.max(max, Math.max(dp[0][t][i], dp[1][t][i]));
        }

        System.out.println(max);
    }
}
