package travelling_salesman_problem;

import java.io.*;
import java.util.*;

public class Baek_16991 {
	static int n;
	static final double MAX = 16*1_000_000;
	static int[][] coordinate = new int[16][2];
	static double[][] graph = new double[16][16];
	static double[][] dp;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		dp = new double[n][1<<n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			coordinate[i][0] = Integer.parseInt(st.nextToken());
			coordinate[i][1] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], -1);
		}

		for(int i = 0;i<n;i++){
			for(int j = 0;j<n;j++){
				if(i==j) continue;
				graph[i][j] = Math.sqrt(
					Math.pow(coordinate[i][0]-coordinate[j][0],2) + Math.pow(coordinate[i][1]-coordinate[j][1],2)
				);
			}
		}

		System.out.println(tsp(0,1));
	}

	static double tsp(int current, int visited) {
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

