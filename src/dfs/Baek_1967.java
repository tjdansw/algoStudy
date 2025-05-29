package dfs;

import java.io.*;
import java.util.*;

public class Baek_1967 {
    static int n, max = 0, farNode = 0;
    static HashMap<Integer, List<Edge>> graph = new HashMap<>();

    static class Edge {
        int next, value;

        Edge(int next, int value) {
            this.next = next;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(new Edge(b, value));
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(new Edge(a, value));
        }

        boolean[] visited = new boolean[n + 1];
        dfs(1, 0, visited);

        Arrays.fill(visited, false);
        max = 0;
        dfs(farNode, 0, visited);

        System.out.println(max);
    }

    static void dfs(int current, int length, boolean[] visited) {
        visited[current] = true;
        if (length > max) {
            max = length;
            farNode = current;
        }

        for (Edge edge : graph.getOrDefault(current, new ArrayList<>())) {
            if (!visited[edge.next]) {
                dfs(edge.next, length + edge.value, visited);
            }
        }
    }
}
