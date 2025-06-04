package bfs;

import java.util.*;
import java.io.*;

public class Baek_1987 {
	static int r, c, max = 0;
	static char[][] map;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		for(int i=0;i<r;i++){
			String line = br.readLine();
			for(int j=0;j<c;j++){
				map[i][j] = line.charAt(j);
			}
		}
		boolean[] visited = new boolean[26];
		visited[map[0][0]-'A'] = true;
		dfs(0, 0, 1, visited);
		System.out.println(max);
	}

	public static void dfs(int x, int y, int cnt, boolean[] visited) {
		max = Math.max(max, cnt);
		for(int i = 0;i<4;i++){
			int row = x+dx[i];
			int col = y+dy[i];
			if(isBound(row,col) && !visited[map[row][col]-'A']){
				visited[map[row][col]-'A'] = true;
				dfs(row,col,cnt+1,visited);
				visited[map[row][col]-'A'] = false;
			}
		}
	}

	public static boolean isBound(int x, int y){
		return x>=0 && x<r && y>=0 && y<c;
	}
}
