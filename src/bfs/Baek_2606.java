package bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2606 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, m, a, b, result = 0;
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_2606.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) list[i] = new ArrayList<>();
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int current = q.poll();
            for(Integer i : list[current]) {
                if(visited[i]) continue;
                q.add(i);
                visited[i] = true;
                result++;
            }
        }
        System.out.println(result);
    }
}
