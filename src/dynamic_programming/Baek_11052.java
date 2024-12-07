package dynamic_programming;
import java.io.*;

public class Baek_11052 {
	static int n;
	static int[] p;
	static int[] dp;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input/Baek_11052.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		p = new int[n+1];
		dp = new int[n+1];
		String[] a = br.readLine().split(" ");
		for(int i = 0;i<n;i++) p[i+1] = Integer.parseInt(a[i]);
		dp[n] = p[n];
		for(int i = 0;i<n;i++) {
			for(int j = 1;j<=n;j++) {
				int index = i+j;
				if(index>n) break;
				dp[index] = Math.max(dp[index], dp[i]+p[j]);
			}
		}
		System.out.println(dp[n]);
	}
}