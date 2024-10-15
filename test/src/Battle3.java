import java.io.*;
import java.util.*;

public class Battle3 {

	static int N, M;
	static char[][] Map;
	static int myX, myY, myHP;
	static int enX, enY, enHP;
	static int norcan, tankcan;
	static int[][] entanknum, entankHP;
	static String order;

	
	static class node {
		int x, y, nor, tank;

		public node(int x, int y, int nor, int tank) {
			this.x = x;
			this.y = y;
			this.nor = nor;
			this.tank = tank;
		}

	}
	
	static int[][] Dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static int[][] DirRe = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static String[] action = {"D", "R", "U", "L"};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] A = br.readLine().split(" ");
		N = Integer.parseInt(A[0]); M = Integer.parseInt(A[1]);
		int E = Integer.parseInt(A[3]);
		
		Map = new char[N][M];
		entanknum = new int[N][M]; entankHP = new int[N][M];
		
		for (int i=0; i<N; i++) {
			A = br.readLine().split(" ");
			for (int j=0; j<M; j++) {
				Map[i][j] = A[j].charAt(0);
				if (Map[i][j] == 'A') {
					myX = i; myY = j; Map[i][j] = 'G';
				}
				
				else if (Map[i][j] == 'X') {
					enX = i; enY = j;
				}
				
				else if (Map[i][j] == 'E') entanknum[i][j] = Integer.parseInt(A[j].substring(1, 2));

			}
			
		}
		
		A = br.readLine().split(" ");
		myHP = Integer.parseInt(A[1]); norcan = Integer.parseInt(A[3]); tankcan = Integer.parseInt(A[4]);
		
		for (int k=0; k<E; k++) {
			A = br.readLine().split(" ");
			if (A[0].charAt(0) == 'X') enHP = Integer.parseInt(A[1]);
			else {
				int n = Integer.parseInt(A[0].substring(1, 2));
				for (int i=0; i<N; i++) {
					for (int j=0; j<M; j++) 
						if (entanknum[i][j] == n) entankHP[i][j] = (Integer.parseInt(A[1])-1)/10+1;
				}
			}
		}

		
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
		
		for (int k=0; k<4; k++) {
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
		
		int[][][][] V = new int[N][M][10][10];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (Map[i][j] == 'W' || Map[i][j] == 'R' || Map[i][j] == 'F') {
					for (int k=0; k<10; k++) {
						for (int l=0; l<10; l++) V[i][j][k][l] = -1;
					}
				}
			}
		}
		
		PriorityQueue<node> pq = new PriorityQueue<>(new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				return V[o1.x][o1.y][o1.nor][o1.tank]-V[o2.x][o2.y][o2.nor][o2.tank];
			}
		});
		
		pq.add(new node(myX, myY, norcan, tankcan)); V[myX][myY][norcan][tankcan] = 1;
		
		while (!pq.isEmpty()) {
			node n = pq.poll();
			int x = n.x, y = n.y, nor = n.nor, tank = n.tank;
			
			for (int k=0; k<4; k++) {
				int nx = x+Dir[k][0], ny = y+Dir[k][1];
				if (check(nx, ny)) {
					if ((Map[nx][ny] == 'G' || Map[nx][ny] == 'X') && V[nx][ny][nor][tank] == 0) {
						V[nx][ny][nor][tank] = V[x][y][nor][tank]+1; pq.add(new node(nx, ny, nor, tank));
					}
					
					else if (Map[nx][ny] == 'T' && nor > 0 && V[nx][ny][nor-1][tank] == 0) {
						V[nx][ny][nor-1][tank] = V[x][y][nor][tank]+2; pq.add(new node(nx, ny, nor-1, tank));
					}
					
					else if (Map[nx][ny] == 'E' && tank >= entankHP[nx][ny] && V[nx][ny][nor][tank-entankHP[nx][ny]] == 0) {
						V[nx][ny][nor][tank-entankHP[nx][ny]] = V[x][y][nor][tank]+entankHP[nx][ny]+1;
						pq.add(new node(nx, ny, nor, tank-entankHP[nx][ny]));
					}
					
					else if (Map[nx][ny] == 'F' && nor < 9 && tank < 9 && V[x][y][nor+1][tank+1] == 0) {
						V[x][y][nor+1][tank+1] = V[x][y][nor][tank]+1; pq.add(new node(x, y, nor+1, tank+1));
					}
				}
			}

		}
		
		int x = enX, y = enY, Z = 0;
		int check = 100000, nor = 0, tank = 0;
		String action2 = "A";

		for (int k=(enHP-1)/10+1; k<10; k++) {
			for (int l=0; l<10; l++)
				if (V[enX][enY][k][l] > 0 && check > V[enX][enY][k][l]) {
					nor = k; tank = l; check = V[enX][enY][k][l];
			}
		}
		
		while (true) {
			for (int k=0; k<4; k++) {
				int nx = x+DirRe[k][0], ny = y+DirRe[k][1];
				if (check(nx, ny)) {
					if ((Map[x][y] == 'G' || Map[x][y] == 'X') && V[nx][ny][nor][tank]+1 == V[x][y][nor][tank]) {
						x = nx; y = ny; action2 = "A"; Z = k; break;
					}
					
					else if (Map[x][y] == 'T' && nor < 9 && V[nx][ny][nor+1][tank]+2 == V[x][y][nor][tank]) {
						x = nx; y = ny; action2 = "F M"; Z = k; nor += 1; break;
					}
					
					else if (Map[x][y] == 'E' && tank+entankHP[x][y] < 10 && V[nx][ny][nor][tank+entankHP[x][y]]+entankHP[x][y]+1 == V[x][y][nor][tank]) {
						tank += entankHP[x][y]; x = nx; y = ny; action2 = "F S"; Z = k; break;
					}
					
					else if (Map[nx][ny] == 'F' && nor > 0 && tank > 0 && V[x][y][nor-1][tank-1]+1 == V[x][y][nor][tank]) {
						Z = (k+2)%4; nor -= 1; tank -= 1; action2 = "G <해독문 출력>"; break;
					}
				}
			}
			
			if (x == myX && y == myY && nor == norcan && tank == tankcan) break;
		}
		
		order = action[Z]+" "+action2;
		
		if (action2.charAt(0) == 'A') {
			myX += Dir[Z][0]; myY += Dir[Z][1];
		}
		
		else if (action2.charAt(0) == 'G') {
			norcan += 1; tankcan += 1;
		}
		
		else if (action2.equals("F S")) {
			tankcan -= 1; entankHP[myX+Dir[Z][0]][myY+Dir[Z][1]] -= 1;
			if (entankHP[myX+Dir[Z][0]][myY+Dir[Z][1]] == 0) Map[myX+Dir[Z][0]][myY+Dir[Z][1]] = 'G';
		}
		else {
			norcan -= 1; Map[myX+Dir[Z][0]][myY+Dir[Z][1]] = 'G';
		}
	}

}
