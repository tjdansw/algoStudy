package dynamic_programming;

import java.util.*;
import java.io.*;

// 15912
public class Baek_15912 {
    static int n;
    static long[] weights, energies;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        weights = new long[n+1];
        energies = new long[n+1];
        dp = new long[n+1];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            weights[i] = Long.parseLong(st1.nextToken());
            energies[i] = Long.parseLong(st2.nextToken());
        }
        for(int i=1;i<=n;i++){
            dp[i] = weights[i] * energies[i] + dp[i-1];
            long maxWeight = weights[i];
            long maxEnergy = energies[i];
            for(int j=i-1;j>0;j--){
                maxWeight = Math.max(maxWeight, weights[j]);
                maxEnergy = Math.max(maxEnergy, energies[j]);
                dp[i] = Math.min(dp[i], maxWeight * maxEnergy + dp[j-1]);
            }
        }
        System.out.println(dp[n]);
    }
}
