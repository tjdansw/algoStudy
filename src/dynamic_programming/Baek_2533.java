package dynamic_programming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_2533 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, u, v, root = 1, max=0;
    static ArrayList<Integer>[] list;
    static ArrayList<int[]> order = new ArrayList<>();
    static int[][] dp;
    static int[] dept;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_2533.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        dp = new int[n+1][2];
        dept = new int[n+1];
        for (int i = 1; i < n+1; i++) list[i] = new ArrayList<>();
        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        for(int i = 1; i < n+1; i++) {
            if(max<list[i].size()) {
                max = list[i].size();
                root = i;
            }
        }
        boolean[] visited = new boolean[n+1];
        visited[root] = true;
        int idx = 0;
        dept[root] = idx;
        order.add(new int[]{root, idx++});
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int current = q.poll();
            for(int child : list[current]) {
                if(visited[child]) continue;
                dept[child] = idx;
                order.add(new int[]{child, idx});
                visited[child] = true;
                q.add(child);
            }
            idx++;
        }

        Collections.sort(order,(o1,o2)->Integer.compare(o2[1],o1[1]));
        for(int[] node: order) {
            int current = node[0];
            dp[current][1] = 1;
            for(Integer prev: list[current]) {
                if(dept[current]>dept[prev]) continue;
                dp[current][0] += dp[prev][1];
                dp[current][1] += Math.min(dp[prev][0],dp[prev][1]);
            }
        }
        System.out.println(Math.min(dp[root][0],dp[root][1]));
    }
}
