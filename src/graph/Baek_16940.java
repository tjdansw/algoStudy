package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 16940
public class Baek_16940 {
    static int n;
    static HashSet<Integer>[] graph;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new HashSet[n+1];
        tree = new int[n];
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<>();
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        if(tree[0]!=1){
            System.out.println(0);
            return;
        }
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        int idx = 1;
        while (!q.isEmpty()){
            int cur = q.poll();

            while (idx<n){
                int next = tree[idx];
                if(graph[cur].contains(next)){
                    visited[next] = true;
                    q.add(next);
                    idx++;
                    continue;
                }
                break;
            }
        }
        System.out.println(idx==n?1:0);
    }
}
