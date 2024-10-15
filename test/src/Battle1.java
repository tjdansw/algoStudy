import java.io.*;
import java.util.*;

public class Battle1 {

	static int N, M;
	static char[][] Map;
	static int myX, myY, myHP;
	static int enX, enY, enHP;
	static int norcan, tankcan;
	static String order;
		
	static class node {
		int x, y;

		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int[][] Dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static int[][] DirRe = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static String[] action = {"D", "R", "U", "L"};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] A = br.readLine().split(" ");
		N = Integer.parseInt(A[0]); M = Integer.parseInt(A[1]);
		
		Map = new char[N][M];
		
		for (int i=0; i<N; i++) {
			A = br.readLine().split(" ");
			for (int j=0; j<M; j++) {
				Map[i][j] = A[j].charAt(0);
				if (Map[i][j] == 'A') {
					myX = i; myY = j; Map[i][j] = 'G';
				}
				
				if (Map[i][j] == 'X') {
					enX = i; enY = j;
				}
			}
			
		}
		
		A = br.readLine().split(" ");
		myHP = Integer.parseInt(A[1]); norcan = Integer.parseInt(A[3]); tankcan = Integer.parseInt(A[4]);
		
		A = br.readLine().split(" ");
		enHP = Integer.parseInt(A[1]);
		
		while (true) {
			if (enHP <= 0) break;
				
			move();
			
			System.out.println(order);
			
		}
		
	}
	
	static boolean check(int a, int b) {
		if (0 <= a && a < N && 0 <= b && b < N) return true;
		return false;
	}
	
	static boolean attack() {
		if (norcan == 0) return false;
		
		for (int k=0; k<Dir.length; k++) {
			int nx = myX+Dir[k][0], ny = myY+Dir[k][1];
			if (check(nx, ny) && Map[nx][ny] == 'X') {
				order = action[k]+" F M"; return true;
			}
		}
		
		return false;
	}
	
	static void move() {
		
		if (attack()) {
			norcan -= 1; enHP -= 10; return;
		}
		
		int[][] V = new int[N][M];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (Map[i][j] != 'G' && Map[i][j] != 'X') V[i][j] = -1;
			}
		}
		
		ArrayDeque<node> D = new ArrayDeque<>(); 
		D.addLast(new node(myX, myY)); V[myX][myY] = 1;
		
		while (!D.isEmpty()) {
			node n = D.removeFirst();
			int x = n.x, y = n.y;
			
			for (int k=0; k<4; k++) {
				int nx = x+Dir[k][0], ny = y+Dir[k][1];
				if (check(nx, ny) && V[nx][ny] == 0) {
					V[nx][ny] = V[x][y]+1; D.addLast(new node(nx, ny));
				}
			}
		}
		
		int x = enX, y = enY, Z = 0;
		char action2 = 'A';
		
		while (true) {
			for (int k=0; k<4; k++) {
				int nx = x+DirRe[k][0], ny = y+DirRe[k][1];
				if (check(nx, ny) && V[nx][ny]+1 == V[x][y]) {
					Z = k; x = nx; y = ny; break;
				}
			}
			
			if (x == myX && y == myY) break;
		}
		
		order = action[Z]+" "+action2;
		myX += Dir[Z][0]; myY += Dir[Z][1];
	}

}
