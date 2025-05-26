package dynamic_programming;

import java.io.*;

public class Baek_16565 {

	static final long MOD = 10_007;
	static int n, fourCardCnt = 1;
	static long total = 0;
	static long[][] dp = new long[53][53];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		init();

		while(fourCardCnt*4 <= n) {
			int cnt = fourCardCnt*4;
			total += (fourCardCnt%2==1?1:-1)*dp[13][fourCardCnt]*dp[52-cnt][n-cnt];
			total %= MOD;
			if(total < 0){
				total += MOD;
			}
			fourCardCnt++;
		}
		System.out.println(total);
	}

	private static void init() {
		dp[0][0] = 1;
		for(int i = 1;i<=52;i++){
			dp[i][0] = 1;
			dp[i][i] = 1;
			for(int j = 1;j<i;j++){
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%MOD;
			}
		}
	}

}