package binary_search;

import java.io.*;
import java.util.*;

public class Baek_15810 {
	static int n,m;
	static long start=0, end;
	static int[] people;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input/Baek_15810.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().trim().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		people = new int[n];
		
		line = br.readLine().trim().split(" ");
		for(int i = 0;i<n;i++) people[i] = Integer.parseInt(line[i]);
		Arrays.sort(people);
		end = (long)people[n-1] * m;
		
		long answer = 0;
		while(start<=end) {
			long mid = (start+end)/2;
			int cnt = 0;
			for(Integer x : people) {
				cnt += mid/x;
				if(cnt>=m) break;
			}
			
			if(cnt<m) {
				start = mid+1;
			}else {
				answer = mid;
				end = mid-1;
			}
		}
		System.out.println(answer);
	}
}

/**
 * PriorityQueue를 사용
public class Baek_15810 {
	static int n,m;
	static PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
		@Override
		public int compare(long[] o1, long[] o2) {
			return Long.compare(o1[1], o2[1]);
		}
	});
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input/Baek_15810.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().trim().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		
		line = br.readLine().trim().split(" ");
		for(int i = 0;i<n;i++) pq.offer(new long[] {Integer.parseInt(line[i]),Integer.parseInt(line[i])});
		
		long time = 0;
		while(m>0) {
			long[] temp = pq.poll();
			time = temp[1];
			temp[1] += temp[0];
			pq.offer(temp.clone());
			m--;
		}
		System.out.println(time);
	}
}
*/
