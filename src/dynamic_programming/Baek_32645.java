package dynamic_programming;

import java.util.*;
import java.io.*;

// 32645
public class Baek_32645 {
    static int n;
    static ArrayList<Integer>[] graph;
    static int[] parent;
    static ArrayList<Integer>[] children;
    static int[] diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        parent = new int[n + 1];
        children = new ArrayList[n + 1];
        diff = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            children[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] order = new int[n];
        int idx = 0;

        Queue<Integer> q = new ArrayDeque<>();
        parent[1] = 0;
        q.add(1);

        while (!q.isEmpty()) {
            int cur = q.poll();
            order[idx++] = cur;

            for (int nxt : graph[cur]) {
                if (nxt == parent[cur]) continue;
                parent[nxt] = cur;
                children[cur].add(nxt);
                q.add(nxt);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int v = order[i];

            if (children[v].isEmpty()) {
                diff[v] = 0;
                continue;
            }

            int best = Integer.MIN_VALUE;
            for (int c : children[v]) {
                best = Math.max(best, 1 - diff[c]);
            }
            diff[v] = best;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(diff[i] > 0 ? "donggggas\n" : "uppercut\n");
        }
        System.out.print(sb);
    }
}