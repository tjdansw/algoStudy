package bfs;
import java.util.*;
import java.io.*;

public class Baek_9019 {
	static char[] order = { 'D', 'S', 'L', 'R' };

	static class Node {
		int value;
		StringBuilder sb;

		public Node(int value, StringBuilder sb) {
			this.value = value;
			this.sb = sb;
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input/Baek_9019.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a;// = br.readLine().split(" ");
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			a = br.readLine().split(" ");
			int start = Integer.parseInt(a[0]);
			int end = Integer.parseInt(a[1]);
			boolean[] visited = new boolean[10000];
			visited[start] = true;
			Queue<Node> q = new LinkedList<>();
			q.add(new Node(start, new StringBuilder()));
			while (!q.isEmpty()) {
				Node current = q.poll();
				if (current.value == end) {
					System.out.println(current.sb.toString());
					break;
				}
				for (int i = 0; i < 4; i++) {
					int nextValue = checkValue(current.value, i);
					if(!visited[nextValue]) {
						q.offer(new Node(nextValue, new StringBuilder().append(current.sb.toString()).append(order[i])));
						visited[nextValue] = true;
					}
				}
			}
		}
	}

	static int checkValue(int value, int order) {
		int result = 0;
		switch (order) {
			case 0: {
				result = (value*2)%10000;
				break;
			}
			case 1: {
				result = value==0?9999:value-1;
				break;
			}
			case 2: {
				result = (value%1000)*10 + value/1000;
				break;
			}
			case 3: {
				result = (value/10) + (value%10)*1000;
				break;
			}
		}
		return result;
	}
}