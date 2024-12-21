package dynamic_programming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Baek_1463 {
    static BufferedReader br;

    static int n;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_1463.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        for(int i =n-1;i>0;i--){
            dp[i] = dp[i+1]+1;
            if(i*2<=n){
                dp[i] = Math.min(dp[i],dp[i*2]+1);
            }
            if(i*3<=n){
                dp[i] = Math.min(dp[i],dp[i*3]+1);
            }
        }
        System.out.println(dp[1]);
    }
}
