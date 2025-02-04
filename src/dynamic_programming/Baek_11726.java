package dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_11726 {
    static BufferedReader br;
    static int n, cnt=0;
    static int[] dp = new int[1001];

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            dp[i] = (dp[i-1]%10007+dp[i-2]%10007)%10007;
        }
        System.out.println(dp[n]);
    }
}