package dynamic_programming;

import java.util.*;
import java.io.*;

// 2565
public class Baek_2565 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums,(a,b)->Integer.compare(a[0],b[0]));
        int[] dp = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j][1] < nums[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(n-max);
    }
}
