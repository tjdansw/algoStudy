import java.io.*;
import java.util.HashSet;

public class Test3_서울_09_우성문 {
	// 영토의 세로 길이와 가로 길이를 저장할 변수
	static int n, m;
	// 영토의 총 양분을 저장할 변수
	static int total;
	// 두 구획에 속한 땅의 양분의 합의 최소 차이를 저장할 변수
	static int min;
	// 영토의 양분을 저장할 2차원 배열
	static int[][] area;

	// 상하좌우를 체크하기 위한 delta배열 - 행
	static int[] dx = { -1, 0, 1, 0 };
	// 상하좌우를 체크하기 위한 delta배열 - 열
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		// 입력값
		System.setIn(new FileInputStream("input3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] line;

		// 테스트케이스 수
		int T = Integer.parseInt(br.readLine().trim());

		// 테스트케이스 수만큼 반복
		for (int tc = 1; tc <= T; tc++) {
			// 영토의 세로 길이과 가로 길이 입력받기
			line = br.readLine().split(" ");
			// 영토의 세로 길이 변수에 저장
			n = Integer.parseInt(line[0]);
			// 영토의 가로 길이 변수에 저장
			m = Integer.parseInt(line[1]);
			// 영토의 총 양분을 저장하기 위한 초기화
			total = 0;

			// n*m크기의 영토 초기화
			area = new int[n][m];
			// n*m크기의 영토의 양분 확인
			for(int i = 0;i<n;i++) {
				// i번째 행의 양분 입력
				line = br.readLine().split(" ");
				for(int j=0;j<m;j++) {
					// (i,j)위치의 영역의 양분 저장
					area[i][j] = Integer.parseInt(line[j]);
					// (i,j)위치의 영역의 양분 total에 더하기
					total += area[i][j];
				}
			}
			// 두 구획에 속한 땅의 양분의 합의 최소 차이를 저장할 변수 초기화
			min = total;
			// 각 영역을 확인했는지 체크하는 boolean 배열
			boolean[][] visited = new boolean[n][m];
			// 시작지점 체크 확인
			visited[0][0] = true;
			System.out.println(total);
			System.out.println();
			// 조건에 맞는 영역을 찾기 위한 메서드 실행
			check(0, 0, new HashSet<Integer>(), 0, visited);
			// n*m 영역을 확인 후 각 색상별 영역의 수를 StrigBuilder에 저장
			sb.append(String.format("#%d %d\n", tc,min));
		}
					
		// 테스트별 저장한 결과값 출력
		System.out.println(sb.toString());
	}
	
	// (x,y) 확인할려는 영역 좌표
	// set : 영역에서 한 구역에 포함되어 있는 좌표를 연산한 값(10*x+y)을 저장한 set집합
	// 한 구역에 포함되어 있는 영역의 총 합
	// vistited 방문했는지 여부
	static void check(int x, int y,HashSet<Integer> set,int areaSum, boolean[][] visited) {
		if(set.size()==n*m) return;
		// 매번 두 구획에 속한 땅의 양분의 합의 차이가 최소인지 확인
		// |A-B| = |total(A+B) - 2*B| 이용
//		min = Math.min(min, Math.abs(total-2*areaSum));
		if(min>Math.abs(total-2*areaSum)) {
			min = Math.abs(total-2*areaSum);
			System.out.println(min+" " +areaSum);
			for(int num:set) {
				System.out.printf("(%d,%d) ",num/10,num%10);
			}
			System.out.println();
		}
		
		// 1. (x,y)를 영역에 속하게 하는 방법
		// 현재 영역에 포함시키기
		set.add(x*10+y);
		// (x,y)에서 인접한 상하좌우 확인
		for(int idx = 0;idx<4;idx++) {
			// (x,y)에서 dx[idx]만큼 이동한 행 위치
			int row = x + dx[idx];
			// 현위치에서 dy[idx]만큼 이동한 열 위치
			int col = y + dy[idx];
			
			// 영역안에 존재하고 방문한 적 없으면
			if(isBound(row, col)&&!visited[row][col]) {
				visited[row][col] = true;
				// (x,y)영역 양분 더하고 다음 좌표로 이동
				check(row, col, set, areaSum+area[x][y], visited);
				visited[row][col] = false;
			}
		}
		// 현재 영역에 제거하기
		set.remove(x*10+y);
		
		// 2. (x,y)를 영역에 속하게 않게 하는 방법
		for(int idx = 0;idx<4;idx++) {
			// (x,y)에서 dx[idx]만큼 이동한 행 위치
			int row = x + dx[idx];
			// 현위치에서 dy[idx]만큼 이동한 열 위치
			int col = y + dy[idx];
			
			// 영역안에 존재하고 방문한 적 없으며 영역에 아무것도 포함되어 있지 않거나 영역에 포함되어 있는 지역에서 접근 가능한 지역이면 
			if(isBound(x, y)&&!visited[x][y]&&(isConnect(row,col,set)||set.size()==0)) {
				visited[row][col] = true;
				// 방문은 했다하고 (x,y)영역 양분 더하지 않고 다음 좌표로 이동
				check(row, col, set, areaSum, visited);
				visited[row][col] = false;
			}
		}
	}
	
	// n*m 영역 안에 위치하는지 체크하는 메서드
	static boolean isBound(int x,int y) {
		return !(x<0||x>=n||y<0||y>=m);
	}
	
	// x,y좌표가 set 영역에서 접근 가능한지 확인하는 메서드
	static boolean isConnect(int x,int y,HashSet<Integer> set) {
		for(int idx = 0;idx<4;idx++) {
			// (x,y)에서 dx[idx]만큼 이동한 행 위치
			int row = x + dx[idx];
			// 현위치에서 dy[idx]만큼 이동한 열 위치
			int col = y + dy[idx];
			if(isBound(row, col)&&set.contains(row*10+col)) {
				return true;
			}
		}
		return false;
	}
}
