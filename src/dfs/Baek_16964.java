package dfs;

import java.util.*;
import java.io.*;

// 16964
public class Baek_16964 {
    static int n, idx = 1;
    static HashSet<Integer>[] graph;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new HashSet[n+1];
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

        tree = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        if(tree[0] != 1){
            System.out.println(0);
            return;
        }
        dfs(1);
        System.out.println(idx==n?1:0);
    }

    static void dfs(int cur){
        if(idx==n){
            return;
        }
        while (idx<n){
            int next = tree[idx];
            if(graph[cur].contains(next)){
                idx++;
                dfs(next);
                continue;
            }
            break;
        }
    }
}
