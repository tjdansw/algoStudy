package lca;

import java.util.*;
import java.io.*;

public class Baek_11437 {
    static int MAX = 100_001;
    static int LOG = 17;
    static List<Integer>[] tree = new ArrayList[MAX];
    static int[][] parent = new int[LOG][MAX];
    static int[] depth = new int[MAX];
    static int n, m;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(1, 0);

        for (int k = 1; k < LOG; k++) {
            for (int i = 1; i <= n; i++) {
                parent[k][i] = parent[k - 1][parent[k - 1][i]];
            }
        }

        m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int cur, int par) {
        depth[cur] = depth[par] + 1;
        parent[0][cur] = par;

        for (int next : tree[cur]) {
            if (next != par) {
                dfs(next, cur);
            }
        }
    }

    static int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int k = LOG - 1; k >= 0; k--) {
            if (depth[a] - (1 << k) >= depth[b]) {
                a = parent[k][a];
            }
        }

        if (a == b) return a;

        for (int k = LOG - 1; k >= 0; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        return parent[0][a];
    }
}
