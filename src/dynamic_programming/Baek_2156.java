package dynamic_programming;
import java.io.*;

public class Baek_2156 {
	static int n;
	static int[] drink;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input/Baek_2156.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		drink = new int[n+1];
		dp = new int[n+1][3];
		for(int i = 0;i<n;i++) drink[i+1] = Integer.parseInt(br.readLine());
		
		if(n<3) {
			int total = 0;
			for(int i = 1;i<=n;i++) total += drink[i];
			System.out.println(total);
				
		}else {
			dp[1][1] = drink[1];
			dp[1][2] = drink[1];
			for(int i = 2;i<=n;i++) {
				dp[i][0] = Math.max(Math.max(dp[i-1][2], dp[i-1][1]), dp[i-1][0]);
				dp[i][1] = dp[i-1][0]+drink[i];
				dp[i][2] = dp[i-1][1]+drink[i];
			}
			System.out.println(Math.max(Math.max(dp[n][0], dp[n][1]), dp[n][2]));
		}
	}
}