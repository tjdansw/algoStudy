package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_1238 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, m, x;
    static ArrayList<Edge>[] list;
    static int[][] minTimes;

    static class Edge{
        int end;
        int time;

        public Edge(int end,int time) {
            this.end = end;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        minTimes = new int[n+1][n+1];
        for(int i=1;i<=n;i++) Arrays.fill(minTimes[i],Integer.MAX_VALUE);
        list = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) list[i] = new ArrayList<>();

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            list[start].add(new Edge(end,time));
        }
        for(int i = 1;i<n+1;i++){
            PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time, o2.time));
            pq.add(new Edge(i,0));
            minTimes[i][i] = 0;
            while(!pq.isEmpty()){
                Edge current = pq.poll();

                for(Edge edge : list[current.end]){
                    if(minTimes[i][edge.end]>current.time+edge.time){
                        minTimes[i][edge.end] = current.time+edge.time;
                        pq.add(new Edge(edge.end,current.time+edge.time));
                    }
                }
            }
        }
        int max = 0;
        for(int i = 1;i<n+1;i++){
            if(i==x) continue;
            int len = minTimes[i][x]+minTimes[x][i];
            max = Math.max(max,len);
        }
        System.out.println(max);
    }
}
