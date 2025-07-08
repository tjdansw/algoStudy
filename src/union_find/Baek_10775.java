package union_find;

import java.io.*;

// 10775
public class Baek_10775 {
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        parent[find(a)] = find(b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        parent = new int[g+1];
        for (int i = 0; i <= g; i++) {
            parent[i] = i;
        }

        int cnt = 0;
        for (int i = 0; i < p; i++) {
            int plane = Integer.parseInt(br.readLine());
            int dockingGate = find(plane);

            if (dockingGate == 0) break;

            cnt++;
            union(dockingGate, dockingGate - 1);
        }

        System.out.println(cnt);
    }
}