package bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_11725 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] parents;
    static HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
    static HashSet<Integer> set;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_11725.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        parents = new int[n+1];

        for(int i =0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            set = graph.getOrDefault(a,new HashSet<>());
            set.add(b);
            graph.put(a,set);
            set = graph.getOrDefault(b,new HashSet<>());
            set.add(a);
            graph.put(b,set);
        }

        q.offer(1);
        while(!q.isEmpty()){
            int parent = q.poll();
            for(int child : graph.get(parent)){
                if(parents[child]==0){
                    parents[child] = parent;
                    q.add(child);
                }
            }
        }

        for(int i =2;i<=n;i++) sb.append(parents[i]).append("\n");
        System.out.println(sb);
    }
}
