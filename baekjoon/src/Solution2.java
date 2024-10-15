import java.util.*;
import java.io.*;

public class Solution2 {
	static int n,m,d,g,t;
	static String[] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/solution2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] line;
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int tc = 1;tc<=T;tc++) {
			line = br.readLine().split(" ");
			n = Integer.parseInt(line[0]);
			m = Integer.parseInt(line[1]);
			map = new String[n];
			visited = new boolean[n][m];
			d = 0;
			g = 0;
			t = 0;
			for(int i = 0;i<n;i++) map[i] = br.readLine();
			
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<m;j++) {
					if(visited[i][j]) continue;
					char ch = map[i].charAt(j);
					switch (ch) {
						case 'D': {
							d++;
							break;
						}
						case 'G': {
							g++;
							break;
						}
						case 'T': {
							t++;
							break;
						}
					}
					visited[i][j] = true;
					Queue<int[]> q = new LinkedList<>();
					q.offer(new int[] {i,j});
					while(!q.isEmpty()) {
						int[] current = q.poll();
						for(int idx = 0;idx<4;idx++) {
							int x = current[0] + dx[idx];
							int y = current[1] + dy[idx];
							if(isBound(x, y)&&!visited[x][y]) {
								char temp = map[x].charAt(y);
								if(temp == ch) {
									visited[x][y] = true;
									q.offer(new int[] {x,y});
								}
							}
						}
					}
				}
			}
			
			sb.append(String.format("#%d %d %d %d\n", tc,d,g,t));
		}
		
		System.out.println(sb.toString());
	}
	
	static boolean isBound(int x,int y) {
		return !(x<0||x>=n||y<0||y>=m);
	}
}
