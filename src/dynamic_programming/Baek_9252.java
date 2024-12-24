package dynamic_programming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * LCS(Longest Common Subsequence, 최장 공통 부분 수열)
 */
public class Baek_9252 {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static char[] str1, str2;
    static int n ,m;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_9252.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine().toCharArray();
        n = str1.length;
        str2 = br.readLine().toCharArray();
        m = str2.length;
        dp = new int[n+1][m+1]; // str1의 처음 i글자와 str2의 처음 j글자까지의 LCS 길이 저장 배열

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 현위치의 문자가 같으면 현위치의 LCS 길이는 이전 위치(dp[i-1][j-1])에 1을 더한 값
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j -  1] + 1;
                } else {
                    // 문자가 다르면 이전 행, 열 두 길이중 최대 길이
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[n][m]);
        
        if(dp[n][m] != 0) {
            // LCS 문자열을 찾을려면 dp계산방법과 역순으로 계산
            while (n > 0 && m > 0) {
                if (str1[n-1] == str2[m-1]) {
                    sb.append(str1[n-1]);
                    n--;
                    m--;
                } else if (dp[n - 1][m] > dp[n][m - 1]) {
                    n--;
                } else {
                    m--;
                }
            }
        }
        System.out.println(sb.reverse());
    }
}
