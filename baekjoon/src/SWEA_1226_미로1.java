import java.util.*;
import java.io.*;

public class SWEA_1226_미로1 {
	static int[][] map;
	static int[] start, end;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		
		String line;
		for(int tc=1;tc<=10;tc++) {
			line = br.readLine();
			map = new int[16][16];
			for(int i = 0;i<16;i++) {
				line = br.readLine();
				for(int j = 0;j<16;j++) {
					map[i][j] = line.charAt(j)-'0';
					if(map[i][j]==2) {
						start = new int[] {i,j};
					}else if(map[i][j]==3) {
						end = new int[] {i,j};
					}
				}
			}
			visited = new boolean[16][16];
			visited[start[0]][start[1]] = true;
			dfs(start[0],start[1]);
			sb.append(String.format("#%d %d\n", tc,(visited[end[0]][end[1]]?1:0)));
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int x,int y) {
		for(int i = 0;i<4;i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			if(isBound(nextX, nextY)&&map[nextX][nextY]!=1&&!visited[nextX][nextY]) {
				visited[nextX][nextY] = true;
				dfs(nextX,nextY);
			}
		}
	}
	
	static boolean isBound(int x,int y) {
		return !(x<0||x>15||y<0||x>15);
	}
}
