package dynamic_programming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2293 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n,k;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_2293.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coins = new int[n];
        dp = new int[k+1];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;
        for(int i=0;i<n;i++){
            for(int j=coins[i];j<=k;j++){
                dp[j] += dp[j-coins[i]];
            }
        }

        System.out.println(dp[k]);
    }
}
