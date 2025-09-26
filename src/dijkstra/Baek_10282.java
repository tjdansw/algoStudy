package dijkstra;

import java.util.*;
import java.io.*;

// 10282
public class Baek_10282 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        ArrayList<int[]>[] graph;
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            boolean[] isInfection = new boolean[n+1];
            graph = new ArrayList[n+1];
            for (int i = 1; i < n+1; i++) graph[i] = new ArrayList<>();
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph[b].add(new int[]{a, s});
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[1], o2[1]));
            pq.add(new int[]{c,0});
            int totalTime = 0;
            int totalCnt = 0;
            while (!pq.isEmpty()){
                int[] node = pq.poll();
                int curCumputer = node[0];
                int curTime = node[1];
                if(isInfection[curCumputer]) continue;
                isInfection[curCumputer] = true;
                totalTime = Math.max(totalTime, curTime);
                totalCnt++;

                for(int[] info:graph[curCumputer]){
                    int next = info[0];
                    int infectionTime = info[1];
                    if(isInfection[next]) continue;
                    int time = curTime + infectionTime;
                    pq.add(new int[]{next, time});
                }
            }
            sb.append(totalCnt).append(' ').append(totalTime).append('\n');
        }

        System.out.println(sb);
    }
}
