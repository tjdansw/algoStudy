package dynamic_programming;

import java.io.*;
import java.util.Arrays;

public class Baek_13398 {
	static int n;
	static int[] nums;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input/Baek_13398.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		nums = new int[n+1];
		dp = new int[n+2][2];
		String[] line = br.readLine().trim().split(" ");
		for(int i = 0;i<n;i++) nums[i+1] = Integer.parseInt(line[i]);
		
		for(int i = n;i>0;i--) {
			if(nums[i]<0) {
				dp[i][1] = dp[i+1][0];
				if(nums[i]+dp[i+1][0]>=0) {
					dp[i][0] = dp[i+1][0] + nums[i];
				}
				if(nums[i]+dp[i+1][1]>=0) {
					dp[i][1] = dp[i+1][1] + nums[i];
				}
			}else {
				dp[i][0] = dp[i+1][0] + nums[i];
				dp[i][1] = dp[i+1][1] + nums[i];
			}
		}
		int answer = Integer.MIN_VALUE;
		for(int i = 1;i<=n;i++) {
			System.out.println(Arrays.toString(dp[i]));
			answer = Math.max(answer, Math.max(dp[i][0],dp[i][1]));
		}
		System.out.println(answer);
	}
}
