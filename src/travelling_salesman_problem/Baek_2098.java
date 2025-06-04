package travelling_salesman_problem;

import java.util.*;
import java.io.*;

public class Baek_2098 {
	static int n;
	static final int MAX = 16*1_000_000;
	static int[][] graph = new int[16][16];
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		dp = new int[n][1<<n];
		for(int i = 0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			Arrays.fill(dp[i], -1);
			for(int j = 0;j<n;j++){
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(tsp(0,1));
	}

	static int tsp(int current, int visited) {
		// 전체 방문 여부
		if(visited == (1<<n)-1){
			return graph[current][0] != 0?graph[current][0]:MAX;
		}

		if(dp[current][visited] != -1) return dp[current][visited];

		dp[current][visited] = MAX;

		for(int i = 0;i<n;i++){
			boolean isNotVisited = (visited & (1<<i)) == 0;
			boolean existLoad = graph[current][i] != 0;
			if(isNotVisited && existLoad){
				dp[current][visited] = Math.min(dp[current][visited], graph[current][i]+tsp(i, visited|(1<<i)));
			}
		}

		return dp[current][visited];
	}
}
