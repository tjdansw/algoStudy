package bfs;

import java.io.*;
import java.util.*;

public class Baek_16928 {
	static int n, m;
	static HashMap<Integer, Integer> ladder = new HashMap<>(); // 시작지점 : 키, 도착지점 : 값
	static boolean[] visisted = new boolean[110];
	static int[] dp = new int[110];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input/Baek_16928.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split(" ");
		n = Integer.parseInt(a[0]);
		m = Integer.parseInt(a[1]);
		for (int i = 0; i < n + m; i++) {
			a = br.readLine().split(" ");
			int start = Integer.parseInt(a[0]);
			int end = Integer.parseInt(a[1]);
			ladder.put(start, end);
		}

		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		while (!q.isEmpty()) {
			if (dp[100] != 0)
				break;
			int current = q.poll();
//				System.out.println(current + " - 값:"+dp[current]);
			for (int d = 6; d > 0; d--) {
				int next = current + d;
				if (visisted[next])
					continue;
				if (ladder.containsKey(next)) {
					int ladderNext = nextIdx(next);
					if (visisted[ladderNext])
						continue;
					q.offer(ladderNext);
					visisted[next] = true;
					visisted[ladderNext] = true;
					dp[ladderNext] = dp[current] + 1;
				} else {
					q.offer(next);
					visisted[next] = true;
					dp[next] = dp[current] + 1;
				}
			}
		}
		System.out.println(dp[100]);
	}

	static int nextIdx(int next) {
		if (ladder.containsKey(next)) {
			return nextIdx(ladder.get(next));
		}
		return next;
	}
}
