import java.io.*;
import java.util.*;

public class Test2_서울_09_우성문 {
	// 삼색 고양이의 무늬의 높이와 너비를 저장할 변수
	static int n,m;
	// 삼색 고양이의 각 무늬 별 영역의 개수를 저장할 변수들
	static int b,o,w;
	// 삼색 고양이의 무늬를 저장할 문자열배열
	static String[] area;
	// 삼색 고양이의 각 무늬를 확인했는지 체크하기 위한 boolean 2차원 배열
	static boolean[][] visited;
	
	// 상하좌우를 체크하기 위한 delta배열 - 행
	static int[] dx = {-1,0,1,0};
	// 상하좌우를 체크하기 위한 delta배열 - 열
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		// 입력값
		System.setIn(new FileInputStream("input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] line;
		

		// 테스트케이스 수
		int T = Integer.parseInt(br.readLine().trim());

		// 테스트케이스 수만큼 반복
		for (int tc = 1; tc <= T; tc++) {
			// 삼색 고양이의 무늬의 높이와 너비 입력받기
			line = br.readLine().split(" ");
			// 삼색 고양이의 무늬의 높이변수에 저장
			n = Integer.parseInt(line[0]);
			// 삼색 고양이의 무늬의 너비변수에 저장
			m = Integer.parseInt(line[1]);
			// 입력받은 삼색 고양이의 무늬의 높이 변수만큼 삼색 고양이의 무늬를 저장한 문자열배열 초기화
			area = new String[n];
			
			// i번째 높이의 무늬 저장
			for(int i = 0;i<n;i++) area[i] = br.readLine();
			
			// 삼색 고양이의 각 무늬 별 영역의 개수를 저장할 변수 0으로 초기화
			b = 0;
			o =0;
			w=0;
			
			// 삼색 고양이의 각 무늬를 확인했는지 체크하기 위한 배열 초기화
			visited = new boolean[n][m];
			
			// n*m 영역 확인하기 위한 배열
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<m;j++) {
					// (i,j)위치 무늬 확인했으면 다음 무늬로 가기
					if(visited[i][j]) continue;
					// (i,j)위치 무늬 색상
					char color = area[i].charAt(j);
					
					// (i,j)위치 무늬 색상의 영역의 수 늘리기
					switch (color) {
						case 'B': {
							b++;
							break;
						}
						case 'O': {
							o++;
							break;
						}
						case 'W': {
							w++;
							break;
						}
					}
					// (i,j)위치에서 상하좌우로 인접한 칸 중 같은 색이 있는 칸 확인하기
					Queue<int[]> q = new LinkedList<>();
					// 현재 위치 삽입
					q.offer(new int[] {i,j});
					// 상하좌우로 인접한 칸 중 같은 색이 있을 때 까지 while문 반복
					while(!q.isEmpty()) {
						// 현 위치
						int[] current = q.poll();
						// 현 위치에서 상하좌우 확인
						for(int idx = 0;idx<4;idx++) {
							// 현위치에서 dx[idx]만큼 이동한 행 위치
							int x = current[0] + dx[idx];
							// 현위치에서 dy[idx]만큼 이동한 열 위치
							int y = current[1] + dy[idx];
							
							// 1. (x,y)가 n*m 영역안에 있는지
							// 2. (x,y)가 (i,j)의 무늬랑 같은 색상인지
							// 3. (x,y)가 무늬를 확인안했는지
							// 위 3가지 조건을 만족하는지 확인
							if(isBound(x, y)&&area[x].charAt(y)==color&&!visited[x][y]) {
								// (x,y)의 무늬를 확인했다고 체크
								visited[x][y] = true;
								// (x,y)위치에서 상하좌우를 확인하기위해 queue에 삽입
								q.offer(new int[] {x,y});
							}
						}
					}
				}
			}
			// n*m 영역을 확인 후 각 색상별 영역의 수를 StrigBuilder에 저장
			sb.append(String.format("#%d %d %d %d\n", tc,b,o,w));
		}
		
		// 테스트별 저장한 결과값 출력
		System.out.println(sb.toString());
	}
	
	// n*m 영역 안에 위치하는지 체크하는 메서드
	static boolean isBound(int x,int y) {
		return !(x<0||x>=n||y<0||y>=m);
	}
}
