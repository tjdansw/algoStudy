package dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_15681 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n, r, q;
    static ArrayList<Integer>[] list;
    static HashSet<Integer>[] set;
    static boolean[] visited;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_15681.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        dp = new int[n+1];
        list = new ArrayList[n+1];
        set = new HashSet[n+1];
        for (int i = 1; i < n+1; i++) {
            list[i] = new ArrayList<>();
            set[i] = new HashSet<>();
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        visited[r] = true;
        while (!queue.isEmpty()) {
            int root = queue.poll();
            for(int next : list[root]) {
                if(visited[next]) continue;
                set[root].add(next);
                visited[next] = true;
                queue.add(next);
            }
        }
        for (int i = 0; i < q; i++){
            int node = Integer.parseInt(br.readLine());
            sb.append(dfs(node)).append("\n");
        }
        System.out.println(sb);
    }

    static int dfs(int current){
        if(dp[current] != 0) return dp[current];
        if(set[current].size()==0){
            dp[current]=1;
            return 1;
        }
        dp[current]=1;
        for(int next : set[current]) {
            dp[current] += dfs(next);
        }
        return dp[current];
    }
}
