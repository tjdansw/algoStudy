package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_11404 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static HashMap<Integer,Node>[] list;
    static int[] result;
    static PriorityQueue<int[]> pq;

    static class Node {
        int end;
        int cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_11404.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new HashMap[n+1];
        result = new int[n+1];
        for (int i = 1; i < n+1; i++) list[i] = new HashMap<>();
        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(!list[a].containsKey(b)||(list[a].containsKey(b)&&list[a].get(b).cost>c)) list[a].put(b,new Node(b, c));
        }
        for(int i = 1; i <= n; i++) {
            Arrays.fill(result, Integer.MAX_VALUE);
            result[i] = 0;
            pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[1], o2[1]);
                }
            });
            pq.add(new int[]{i,0});
            while(!pq.isEmpty()) {
                int[] current = pq.poll();
                for(Node node:list[current[0]].values()){
                    if(result[node.end]>current[1]+node.cost) {
                        result[node.end] = current[1]+node.cost;
                        pq.add(new int[]{node.end,current[1]+node.cost});
                    }
                }
            }
            for(int j = 1; j <= n; j++) sb.append(result[j]==Integer.MAX_VALUE?0:result[j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
