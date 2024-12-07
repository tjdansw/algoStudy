package brute_force;

import java.io.*;

public class Baek_23301 {
	static int n, t, k, answer=0,max=0;
	static int[] times = new int[1001];
	static int[] subSum = new int[1001];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input/Baek_23301.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().trim().split(" ");
		n = Integer.parseInt(line[0]);
		t = Integer.parseInt(line[1]);

		for (int p = 0; p < n; p++) {
			k = Integer.parseInt(br.readLine());
			for (int i = 0; i < k; i++) {
				line = br.readLine().trim().split(" ");
				int start = Integer.parseInt(line[0]);
				int end = Integer.parseInt(line[1]);
				for(int time=start+1;time<=end;time++) times[time]++;
			}
		}
		
		for(int i = 1;i<1001;i++) {
			subSum[i] = subSum[i-1]+times[i];
		}
		
		for(int i = 0;i<1001-t;i++) {
			if(max<subSum[i+t]-subSum[i]) {
				max = subSum[i+t]-subSum[i];
				answer = i;
			}
		}
		System.out.println(answer+" "+(answer+t));
	}
}
