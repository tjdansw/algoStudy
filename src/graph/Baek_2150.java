package graph;

import java.util.*;
import java.io.*;

// 2150
public class Baek_2150 {
    static int v, e;
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer>[] rGraph;
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();
    static ArrayList<ArrayList<Integer>> sccList = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[v + 1];
        rGraph = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
            rGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            rGraph[b].add(a);
        }

        visited = new boolean[v + 1];
        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {
                dfs1(i);
            }
        }

        Arrays.fill(visited, false);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                ArrayList<Integer> comp = new ArrayList<>();
                dfs2(v, comp);
                Collections.sort(comp);
                sccList.add(comp);
            }
        }

        Collections.sort(sccList, (a, b) -> Integer.compare(a.get(0), b.get(0)));

        StringBuilder sb = new StringBuilder();
        sb.append(sccList.size()).append('\n');
        for (ArrayList<Integer> comp : sccList) {
            for (int x : comp) {
                sb.append(x).append(' ');
            }
            sb.append("-1\n");
        }
        System.out.print(sb);
    }

    static void dfs1(int cur) {
        visited[cur] = true;
        for (int next : graph[cur]) {
            if (!visited[next]) {
                dfs1(next);
            }
        }
        stack.push(cur);
    }

    static void dfs2(int cur, ArrayList<Integer> comp) {
        visited[cur] = true;
        comp.add(cur);
        for (int next : rGraph[cur]) {
            if (!visited[next]) {
                dfs2(next, comp);
            }
        }
    }
}