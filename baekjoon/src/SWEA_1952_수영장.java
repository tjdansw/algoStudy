import java.util.*;
import java.io.*;

public class SWEA_1952_수영장 {
	static int[] dp;
	static int[] price = new int[4];
	static int[] month;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); 
		String[] line;
		for(int tc=1;tc<=T;tc++) {
			dp = new int[13];
			month = new int[13];
			line = br.readLine().split(" ");
			for(int i=0;i<4;i++) price[i] = Integer.parseInt(line[i]);
			line = br.readLine().split(" ");
			for(int i=0;i<12;i++) month[i+1] = Integer.parseInt(line[i]);
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[12] = price[3];
			dp[0] = 0;
			for(int i = 1;i<13;i++) {
				dp[i] = Math.min(dp[i], dp[i-1]+Math.min(month[i]*price[0],price[1]));
				if(i>=3) {
					dp[i] =Math.min(dp[i], dp[i-3] + price[2]);
				}
			}
			sb.append(String.format("#%d %d\n", tc,dp[12]));
		}
		System.out.println(sb.toString());
	}
}
