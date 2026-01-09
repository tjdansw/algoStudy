package bfs;

import java.util.*;
import java.io.*;

// 22868
public class Baek_22868 {
    static int n, m, s, e;
    static ArrayList<Integer>[] graph;
    static boolean[] deleteNode;

    static class Edge{
        int to, len;
        StringBuilder route;

        public Edge(int to, int len, StringBuilder route) {
            this.to = to;
            this.len = len;
            this.route = route;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        deleteNode = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 1; i <= n; i++) Collections.sort(graph[i]);

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        int answer = 0;
        String sToe = minimumMoveLen(s, e);
        String[] nodes = sToe.split(" ");
        answer += nodes.length-1;
        for (int i = 1; i < nodes.length-1; i++) {
            int idx = Integer.parseInt(nodes[i]);
            deleteNode[idx] = true;
        }
        String eTos = minimumMoveLen(e, s);
        nodes = eTos.split(" ");
        answer += nodes.length-1;

        System.out.println(answer);
    }

    static String minimumMoveLen(int a, int b){
        ArrayList<String> answers = new ArrayList<>();
        int minimumLen = 10_001;
        boolean[] visited = new boolean[n+1];
        Queue<Edge> q = new LinkedList<>();
        StringBuilder route = new StringBuilder();
        route.append(a);
        q.add(new Edge(a, 0, route));
        visited[a] = true;
        while (!q.isEmpty()) {
            Edge node = q.poll();
            int current = node.to;
            int len = node.len;
            for(int next:graph[current]){
                if(visited[next]||deleteNode[next]) continue;
                if(next==b&&len+1<=minimumLen){
                    if(len+1<minimumLen){
                        answers.clear();
                    }
                    StringBuilder answer = new StringBuilder();
                    answer.append(node.route.toString()).append(' ').append(b);
                    answers.add(answer.toString());
                    minimumLen = len+1;
                    continue;
                }else if(next==b||len>minimumLen){
                    continue;
                }
                visited[next] = true;
                StringBuilder nextRoute = new StringBuilder();
                nextRoute.append(node.route.toString()).append(' ').append(next);
                q.add(new Edge(next, len+1, nextRoute));
            }
        }
        Collections.sort(answers);
        return answers.get(0);
    }
}
