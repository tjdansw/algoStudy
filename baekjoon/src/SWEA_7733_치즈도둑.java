import java.util.*;
import java.io.*;

public class SWEA_7733_치즈도둑 {
	static int n,max;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		
		String[] line;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			max = 1;
			for(int i = 0;i<n;i++) {
				line = br.readLine().split(" ");
				for(int j = 0;j<n;j++) {
					map[i][j] = Integer.parseInt(line[j]);
				}
			}
			for(int day = 1;day<100;day++) {
				visited = new boolean[n][n];
				int cnt = 0;
				for(int i = 0;i<n;i++) {
					for(int j = 0;j<n;j++) {
						if(day>=map[i][j]||visited[i][j]) continue;
						cnt++;
						visited[i][j] = true;
						Queue<int[]> q = new LinkedList<>();
						q.offer(new int[] {i,j});
						while(!q.isEmpty()) {
							int[] current = q.poll();
							for(int idx = 0;idx<4;idx++) {
								int x = current[0]+dx[idx];
								int y = current[1]+dy[idx];
								if(isBound(x, y)&&!visited[x][y]&&map[x][y]>day) {
									q.offer(new int[] {x,y});
									visited[x][y] = true;
								}
							}
						}
					}
				}
				max = Math.max(max, cnt);
			}
			sb.append(String.format("#%d %d\n", tc,max));
		}
		System.out.println(sb.toString());
	}
	
	static boolean isBound(int x,int y) {
		return !(x<0||x>=n||y<0||y>=n);
	}
}
