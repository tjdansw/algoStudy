package dynamic_programming;

import java.io.*;

// 5582
public class Baek_5582 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] wordArrays = {br.readLine().toCharArray(), br.readLine().toCharArray()};
        int n = wordArrays[0].length;
        int m = wordArrays[1].length;
        int[][] dp = new int[n+1][m+1];
        int res = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(wordArrays[0][i-1] == wordArrays[1][j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        System.out.println(res);
    }
}
