package topology_sort;

import java.util.*;
import java.io.*;

// 5021
public class Baek_5021 {
    static int n, m;
    static Map<String,Integer> id = new HashMap<>();
    static List<Integer>[] g;
    static int[] indeg;
    static double[] blood;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int idx = 0;
        String founder = br.readLine();
        id.put(founder, idx++);

        List<String[]> rel = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String p1 = st.nextToken();
            String p2 = st.nextToken();
            if (!id.containsKey(child)) id.put(child, idx++);
            if (!id.containsKey(p1)) id.put(p1, idx++);
            if (!id.containsKey(p2)) id.put(p2, idx++);
            rel.add(new String[]{child, p1, p2});
        }

        g = new ArrayList[idx];
        for (int i = 0; i < idx; i++) g[i] = new ArrayList<>();
        indeg = new int[idx];
        blood = new double[idx];

        for (String[] r : rel) {
            int c = id.get(r[0]);
            int p1 = id.get(r[1]);
            int p2 = id.get(r[2]);
            g[p1].add(c);
            g[p2].add(c);
            indeg[c] += 2;
        }

        Queue<Integer> q = new ArrayDeque<>();
        int founderId = id.get(founder);
        blood[founderId] = 1.0;

        for (int i = 0; i < idx; i++) {
            if (indeg[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g[u]) {
                blood[v] += blood[u] / 2.0;
                if (--indeg[v] == 0) q.offer(v);
            }
        }

        String answer = null;
        double best = -1.0;
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            double val = 0.0;
            if (id.containsKey(name)) val = blood[id.get(name)];
            if (val > best) {
                best = val;
                answer = name;
            }
        }
        System.out.println(answer);
    }
}
