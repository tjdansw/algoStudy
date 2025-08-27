package dynamic_programming;

import java.io.*;

// 2011
public class Baek_2011 {
    static final int MOD = 1_000_000;
    static int n;
    static int[] array;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        n = line.length();
        array = new int[n];
        dp = new int[n+1];
        for(int i = 0; i < n; i++){
            array[i] = line.charAt(i) - '0';
        }
        dp[n] = 1;
        dp[n-1] = array[n-1]==0?0:1;
        for(int i = n-2; i >= 0; i--) {
            if(array[i] == 0) continue;
            int value = 10*array[i]+array[i+1];
            if(value<=26){
                dp[i] += dp[i+2];
            }
            dp[i] += dp[i+1];
            dp[i] %= MOD;
        }
        System.out.println(dp[0]);
    }
}
