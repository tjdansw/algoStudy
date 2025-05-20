package dijkstra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_11779 {
	static int n, m;
	static int start, end;
	static ArrayList<int[]>[] graph;
	static long[] dp;
	static int[] prev;
	static boolean[] visited;
	static ArrayList<Integer> result = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		dp = new long[n+1];
		prev = new int[n+1];
		visited = new boolean[n+1];
		graph = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
			dp[i] = Integer.MAX_VALUE;
		}

		for(int i = 0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			graph[a].add(new int[] {b,value});
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		dp[start] = 0;

		PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->Long.compare(dp[a],dp[b]));
		q.add(start);
		while(!q.isEmpty()){
			int cur = q.poll();
			if(visited[cur]){
				continue;
			}
			visited[cur] = true;
			if(cur == end){
				break;
			}
			for(int[] edge : graph[cur]){
				int next= edge[0];
				long value = dp[cur]+edge[1];
				if(dp[next]>value){
					dp[next] = value;
					prev[next] = cur;
					q.add(next);
				}
			}
		}

		System.out.println(dp[end]);
		int cur = end;
		while(true){
			result.add(cur);
			if(cur==start){
				break;
			}
			cur = prev[cur];
		}
		System.out.println(result.size());
		for(int i=result.size()-1;i>=0;i--){
			System.out.print(result.get(i)+" ");
		}
	}
}
