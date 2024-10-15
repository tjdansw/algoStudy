import java.io.*;

public class Test1_서울_09_우성문 {
	// 계단 높이를 저장할 변수
	static int h;
	// i번째 계단까지 도착할 수 있는 방법의 경우의 수를 저장할 dp배열(최대 계단수가 60까지므로 61크기의 배열 선언) 
	static long[] dp = new long[61];
	// 냥싸피가 한번 올라갈 수 있는 계단 수
	static int[] move = {1,3,4};
	
	public static void main(String[] args) throws Exception{
		// 입력값
		System.setIn(new FileInputStream("input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Dynamic Programming을 사용할 예정이므로 먼저 계산해서 저장할 예정
		// 시작지점은 1가지 방법밖에 없으므로 1로 초기화
		dp[0]=1;
		// 1번째 계단부터 60번째 계단까지 도착할 수 있는 방법의 경우의 수를 계산하기 위한 반복문
		for(int i = 0;i<60;i++) {
			// 냥싸피가 움직일 수 있는 방법(1,3,4)
			for(int num : move) {
				// 다음 계단 위치
				int next = i+num;
				// 다음 계단이 60보다 크면 건너뛰기
				if(next>60) continue;
				// i번째 계단으로 가는 가지 수를 next계단을로 갈 수 있는 가지수에 더하기
				dp[next] += dp[i];
			}
		}
		
		// 테스트케이스 수
		int T = Integer.parseInt(br.readLine().trim());

		// 테스트케이스 수만큼 반복
		for (int tc = 1; tc <= T; tc++) {
			// tc번째 테스트에서 오르고자하는 계단 높이
			h = Integer.parseInt(br.readLine().trim());
			// tc번째 테스트에서 목표 높이까지의 경우의수 출력 문자 저장
			sb.append(String.format("#%d %d\n", tc,dp[h]));
		}
		
		// 저장한 총 테스트케이스 출력문 출력
		System.out.println(sb.toString());
	}
}
