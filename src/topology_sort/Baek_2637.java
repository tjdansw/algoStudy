package topology_sort;

import java.util.*;
import java.io.*;

// 2637
public class Baek_2637 {
    static int n, m;
    static int[] indegree;
    static boolean[] isComposite;
    static ArrayList<Edge>[] graph;
    static HashMap<Integer, Integer>[] need;

    static class Edge{
        int to, cnt;
        public Edge(int to, int cnt) {
            this.to = to;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        indegree = new int[n+1];
        isComposite = new boolean[n+1];
        graph = new ArrayList[n+1];
        need = new HashMap[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            need[i] = new HashMap<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[b].add(new Edge(a, c));
            isComposite[a] = true;
            indegree[a]++;
        }



        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(!isComposite[i]){
                need[i].put(i, 1);
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();

            for(Edge next : graph[cur]){
                int to = next.to; // to를 제작하기 위한
                int cnt = next.cnt; // cur의 필요 개수

                for(int key : need[cur].keySet()){
                    int add = need[cur].get(key) * cnt;
                    need[to].put(key, need[to].getOrDefault(key, 0) + add);
                }

                indegree[to]--;
                if(indegree[to] == 0){
                    q.add(to);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (!isComposite[i]) {
                int cnt = need[n].getOrDefault(i, 0);
                if (cnt > 0) sb.append(i).append(' ').append(cnt).append('\n');
            }
        }
        System.out.print(sb);
    }
}
