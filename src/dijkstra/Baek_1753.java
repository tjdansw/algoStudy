package dijkstra;

import java.util.*;
import java.io.*;

// 1753
public class Baek_1753 {
    static int v, e, start;
    static int[] minMoveLen;
    static HashMap<Integer, Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        minMoveLen = new int[v+1];
        Arrays.fill(minMoveLen, Integer.MAX_VALUE);
        graph = new HashMap[v+1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new HashMap<>();
        }

        start = Integer.parseInt(br.readLine());
        minMoveLen[start] = 0;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph[a].put(b,Math.min(graph[a].getOrDefault(b,10),value));
        }

        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->Integer.compare(minMoveLen[a], minMoveLen[b]));
        q.add(start);
        while (!q.isEmpty()){
            int cur = q.poll();
            for(Integer next:graph[cur].keySet()){
                int moveLen = minMoveLen[cur]+graph[cur].get(next);
                if(minMoveLen[next]>moveLen){
                    minMoveLen[next] = moveLen;
                    q.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            sb.append(minMoveLen[i]==Integer.MAX_VALUE?"INF":minMoveLen[i]).append('\n');
        }
        System.out.println(sb);
    }
}
