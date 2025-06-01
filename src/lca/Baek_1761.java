package lca;

import java.util.*;
import java.io.*;

public class Baek_1761 {

    static final int MAX = 40_001;
    static final int LOG = (int)Math.ceil(Math.log(MAX)/Math.log(2));
    static List<int[]>[] tree = new ArrayList[MAX];
    static int[][] parent = new int[LOG][MAX];
    static int[] len = new int[MAX];
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
            int k = Integer.parseInt(st.nextToken());

            tree[u].add(new int[] {v, k});
            tree[v].add(new int[] {u, k});
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
            int lcaIdx = lca(a, b);
            int totalLen = len[a]+len[b]-2*len[lcaIdx];
            sb.append(totalLen).append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int cur, int par) {
        depth[cur] = depth[par] + 1;
        parent[0][cur] = par;

        for (int[] node : tree[cur]) {
            int next = node[0];
            int val = node[1];
            if (next != par) {
                len[next] = len[cur] + val;
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
