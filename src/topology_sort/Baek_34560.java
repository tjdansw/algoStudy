package topology_sort;

import java.util.*;
import java.io.*;

// 34560
public class Baek_34560 {
    static int n;
    static Player[] players;
    static ArrayList<Integer>[] graph;
    static int[] indegree;

    static class Player{
        String name;
        int p, a, s;

        public Player(String name, int p, int a, int s) {
            this.name = name;
            this.p = p;
            this.a = a;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        players = new Player[n];
        graph = new ArrayList[n];
        indegree = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int p = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            players[i] = new Player(name, p, a, s);
        }
        Arrays.sort(players, (a,b)->a.name.compareTo(b.name));

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int winI = winCnt(players[i], players[j]);
                int winJ = winCnt(players[j], players[i]);

                if (winI > winJ) {
                    graph[i].add(j);
                    indegree[j]++;
                } else if (winJ > winI) {
                    graph[j].add(i);
                    indegree[i]++;
                }
            }
        }

        int[] indegWork = indegree.clone();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            if (indegWork[i] == 0) q.add(i);

        int visited = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            visited++;
            for (int nxt : graph[cur]) {
                if (--indegWork[nxt] == 0)
                    q.add(nxt);
            }
        }

        if (visited < n) {
            System.out.println("Paradoxe Absurdo");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                sb.append(players[i].name).append('\n');
        }
        System.out.println(sb);
    }

    static int winCnt(Player a, Player b){
        int res = 0;
        res += a.p>=b.p?1:0;
        res += a.a>=b.a?1:0;
        res += a.s>=b.s?1:0;
        return res;
    }
}
