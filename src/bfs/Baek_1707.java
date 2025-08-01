package bfs;

import java.util.*;
import java.io.*;

// 1707
public class Baek_1707 {
    static HashSet<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < k; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph = new HashSet[v+1];
            for (int i = 0; i < v+1; i++) {
                graph[i] = new HashSet<>();
            }
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            int[] nodeColors = new int[v+1];
            boolean isBipartiteGraph = true;
            for (int i = 1; i < v+1&&isBipartiteGraph; i++) {
                if(nodeColors[i] != 0){
                    continue;
                }
                nodeColors[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()&&isBipartiteGraph) {
                    int cur = q.poll();
                    for(int next : graph[cur]) {
                        if(nodeColors[next] == 0){
                            nodeColors[next] = nodeColors[cur] * -1;
                            q.offer(next);
                        }else if(nodeColors[next] == nodeColors[cur]){
                            isBipartiteGraph = false;
                            break;
                        }
                    }
                }
            }
            sb.append(isBipartiteGraph?"YES\n":"NO\n");
        }
        System.out.println(sb);
    }
}
