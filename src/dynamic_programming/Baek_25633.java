package dynamic_programming;

import java.io.*;

public class Baek_25633 {
	static int n;
	static int[] blocks,dp;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input/Baek_25633.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		blocks = new int[n];
		dp = new int[n];
		String[] line = br.readLine().trim().split(" ");
		for(int i  = 0;i<n;i++) blocks[i] = Integer.parseInt(line[i]);
		
		for(int i = 0;i<n;i++) {
			int sum = blocks[i];
			dp[i] = 1;
			for(int j = i+1;j<n;j++) {
				if(sum>=blocks[j]) {
					dp[i]++;
					sum += blocks[j];
				}
			}
		}
		
		int max = 0;
		for(int i = 0;i<n;i++) max = Math.max(max, dp[i]);
		System.out.println(max);
	}
}
