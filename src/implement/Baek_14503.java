package implement;
import java.io.*;

public class Baek_14503 {
	static int n,m,x,y,d,cnt=0;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[] bx = {1,0,-1,0};
	static int[] by = {0,-1,0,1};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input/Baek_14503.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		map = new int[n][m];
		line = br.readLine().split(" ");
		x = Integer.parseInt(line[0]);
		y = Integer.parseInt(line[1]);
		d = Integer.parseInt(line[2]);
		for(int i = 0;i<n;i++) {
			line = br.readLine().split(" ");
			for(int j = 0;j<m;j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		while(true) {
			if(map[x][y]==0) {
				cnt++;
				 map[x][y]=2;
			}
			if(check(x, y)) {
				d = d==0?3:d-1;
				int nextX = x+dx[d];
				int nextY = y+dy[d];
				if(isBound(nextX, nextY)&&map[nextX][nextY]==0) {
					x = nextX;
					y = nextY;
				}
			}else {
				x +=bx[d];
				y +=by[d];
				if(!isBound(x, y)||map[x][y]==1) break;
			}
		}
		System.out.println(cnt);
	}
	
	static boolean isBound(int r,int c) {
		return !(r<0||r>=n||c<0||c>=m);
	}
	
	static boolean check(int r,int c) {
		for(int i = 0;i<4;i++) {
			int nextX = r+dx[i];
			int nextY = c+dy[i];
			if(isBound(nextX, nextY)&&map[nextX][nextY]==0) return true;
		}
		return false;
	}
}
