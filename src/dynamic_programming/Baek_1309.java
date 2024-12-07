package dynamic_programming;

import java.util.*;

public class Baek_1309 {
	static int n;
	static int[][] dp;
			
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int[n][3];
		Arrays.fill(dp[0], 1);
		
		for(int i = 1;i<n;i++) {
			dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%9901;
			dp[i][1] = (dp[i-1][0]+dp[i-1][2])%9901;
			dp[i][2] = (dp[i-1][0]+dp[i-1][1])%9901;
		}
		System.out.println((dp[n-1][0]+dp[n-1][1]+dp[n-1][2])%9901);
	}
}
