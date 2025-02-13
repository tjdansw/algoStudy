package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_12851 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, k, cnt = 0;
    static Queue<int[]> q = new LinkedList<>();
    static int[] visited = new int[1000001];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(visited, 100001);
        visited[n] = 0;
        q.add(new int[]{n, 0});
        while (!q.isEmpty()) {
            int[] current = q.poll();
            if (visited[current[0]] < current[1]&&current[0]!=k) continue;
            if (current[0] == k) {
                if(visited[current[0]] >=current[1]){
                    visited[k] = current[1];
                    cnt++;
                }else{
                    break;
                }
            }else{
                visited[current[0]] = current[1];
            }
            if (current[0] * 2 < 100001 && current[0] != 0) {
                q.add(new int[]{current[0] * 2, current[1] + 1});
            }
            if (current[0] < 100000) {
                q.add(new int[]{current[0] + 1, current[1] + 1});
            }
            if (current[0] > 0) {
                q.add(new int[]{current[0] - 1, current[1] + 1});
            }
        }
        System.out.println(visited[k] + "\n" + cnt);
    }
}
