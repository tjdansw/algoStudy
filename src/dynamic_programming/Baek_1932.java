package dynamic_programming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_1932 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n;
    static int[][] tree,dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_1932.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new int[n+2][n+2];
        dp = new int[n+2][n+2];

        for(int i = 1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1;j<=i;j++){
                tree[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = tree[i][j]+Math.max(dp[i-1][j-1],dp[i-1][j]);
            }
        }

        Arrays.sort(dp[n]);
        System.out.println(dp[n][n+1]);
        /*
        // 정렬 후 최댓값 출력하는 코드와 for문으로 최대값 찾는 코드를 비교했을 때 for문으로 찾는게 8ms더 빨랐음
        // 왜지?
        int max = 0;
        for(int i = 1;i<=n;i++){
            max = Math.max(max,dp[n][i]);
        }
        System.out.println(max);
         */
    }
}
