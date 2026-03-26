package dynamic_programming;

import java.util.*;
import java.io.*;

// 11066
public class Baek_11066 {
    static int k;
    static int[] files, subSum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            k = Integer.parseInt(br.readLine());
            files = new int[k + 1];
            subSum = new int[k + 1];
            dp = new int[k + 1][k + 1];


            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= k; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                subSum[i] = subSum[i - 1] + files[i];
            }
            for (int len = 2; len <= k; len++) {
                for (int start = 1; start + len - 1 <= k; start++) {
                    int end = start + len - 1;
                    dp[start][end] = Integer.MAX_VALUE;
                    int sum = subSum[end]-subSum[start-1];

                    for (int mid = start; mid < end; mid++) {
                        dp[start][end] = Math.min(dp[start][end], dp[start][mid]+dp[mid+1][end] + sum);
                    }
                }
            }
            answer.append(dp[1][k]).append('\n');
        }
        System.out.println(answer);
    }
}
