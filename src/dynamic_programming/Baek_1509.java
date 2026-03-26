package dynamic_programming;

import java.util.*;
import java.io.*;

// 1509
public class Baek_1509 {
    static int n;
    static char[] array;
    static boolean[][] isPalindrome;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        n = line.length();
        array = new char[n+1];
        for (int i = 1; i <= n; i++) {
            array[i] = line.charAt(i-1);
        }
        isPalindrome = new boolean[n+1][n+1];
        dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 1; i < n; i++) {
            if (array[i] == array[i + 1]) {
                isPalindrome[i][i + 1] = true;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int l = 1; l + len - 1 <= n; l++) {
                int r = l + len - 1;
                if (array[l] == array[r] && isPalindrome[l + 1][r - 1]) {
                    isPalindrome[l][r] = true;
                }
            }
        }
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int r = 1; r <= n; r++) {
            for (int l = 1; l <= r; l++) {
                if(isPalindrome[l][r]){
                    dp[r] = Math.min(dp[r], dp[l-1]+1);
                }
            }
        }
        System.out.println(dp[n]);
    }
}
