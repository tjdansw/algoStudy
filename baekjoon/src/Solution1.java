import java.io.*;
import java.util.*;

public class Solution1 {
	static int n;
	static int[] btns = {1,3,4};
	static long[] dp;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/solution1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int tc = 1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine().trim());
			dp = new long[n+1];
			dp[0]=1;
			for(int i = 0;i<=n;i++) {
				for(Integer btn : btns) {
					int next = i+btn;
					if(next<=n) {
						dp[next]+=dp[i];
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(dp[n]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
