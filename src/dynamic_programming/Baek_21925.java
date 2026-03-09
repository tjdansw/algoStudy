package dynamic_programming;

import java.util.*;
import java.io.*;

// 21925
public class Baek_21925 {
    static int n;
    static int[] nums, dp;
    static boolean[][] isPalindrome;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n+1];
        dp = new int[n+1];
        isPalindrome = new boolean[n+1][n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, -1);
        dp[0] = 0;

        //
        for (int len = 2; len <= n; len += 2) {
            for (int l = 1; l + len - 1 <= n; l++) {
                int r = l + len - 1;

                if (nums[l] != nums[r]) continue;

                if (len == 2) {
                    isPalindrome[l][r] = true;
                } else {
                    isPalindrome[l][r] = isPalindrome[l + 1][r - 1];
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (isPalindrome[j][i] && dp[j - 1] != -1) {
                    dp[i] = Math.max(dp[i], dp[j - 1] + 1);
                }
            }
        }

        System.out.println(dp[n] < 0 ? -1 : dp[n]);
    }
}
