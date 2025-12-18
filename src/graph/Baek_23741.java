package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 23741
public class Baek_23741 {
    static int n, m, x, y;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] curr = new boolean[n + 1];
        curr[x] = true;

        for (int step = 1; step <= y; step++) {
            boolean[] next = new boolean[n + 1];

            for (int u = 1; u <= n; u++) {
                if (!curr[u]) continue;
                for (int v : graph[u]) {
                    next[v] = true;
                }
            }

            curr = next;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (curr[i]) sb.append(i).append(' ');
        }

        System.out.println(sb.length()==0?-1:sb);
    }
}
