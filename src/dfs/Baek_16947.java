package dfs;

import java.io.*;
import java.util.*;

// 16947
public class Baek_16947 {
    static int n;
    static ArrayList<Integer>[] graph;
    static boolean[] isCycled = null;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        answer = new int[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1, 0, 0, new int[n], new boolean[n+1]);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(isCycled[i]){
                answer[i] = 0;
                q.add(i);
                continue;
            }
            answer[i] = -1;
        }

        while (!q.isEmpty()){
            int current = q.poll();
            for (int next:graph[current]){
                if(answer[next]>=0) continue;
                answer[next] = answer[current] +1;
                q.add(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(answer[i]).append(' ');
        System.out.println(sb);
    }

    static void dfs(int current, int prev, int dept,int[] root, boolean[] isVisited){
        if(isCycled != null) return;
        if(isVisited[current]){
            isCycled = new boolean[n+1];
            for (int i = dept-1; i >= 0; i--) {
                int node = root[i];
                isCycled[node] = true;
                if(node==current) break;
            }
            return;
        }
        isVisited[current] = true;
        root[dept] = current;
        for(int next:graph[current]){
            if(next == prev) continue;
            dfs(next, current, dept+1, root, isVisited);
        }
        root[dept] = 0;
    }
}
