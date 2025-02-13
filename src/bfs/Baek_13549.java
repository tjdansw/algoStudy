package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_13549 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, k;
    static boolean[] visited = new boolean[200001];
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        pq.add(new int[]{n, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            if (visited[current[0]]) continue;
            visited[current[0]] = true;
            if (current[0] == k) {
                System.out.println(current[1]);
                break;
            }
            if (current[0] * 2 < 200001 && current[0] != 0) {
                pq.add(new int[]{current[0] * 2, current[1]});
            }
            if (current[0] < 100000) {
                pq.add(new int[]{current[0] + 1, current[1] + 1});
            }
            if (current[0] > 0) {
                pq.add(new int[]{current[0] - 1, current[1] + 1});
            }
        }
    }
}
