package math;

import java.util.*;
import java.io.*;

// 10216
public class Baek_10216 {
    static int n;
    static int[] parent;

    static class Node{
        int x, y ,r;

        public Node(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
    
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            n = Integer.parseInt(br.readLine());
            Node[] camps = new Node[n];
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                camps[i] = new Node(x, y, r);
                parent[i] = i;
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (connected(camps[i], camps[j])) {
                        union(i, j);
                    }
                }
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(find(i));
            }

            sb.append(set.size()).append('\n');
        }
        System.out.println(sb);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa != pb) {
            parent[pb] = pa;
        }
    }

    static boolean connected(Node a, Node b) {
        long dx = a.x - b.x;
        long dy = a.y - b.y;
        long distSq = dx * dx + dy * dy;

        long rSum = (long) a.r + b.r;
        long rSq = rSum * rSum;

        return distSq <= rSq;
    }

}
