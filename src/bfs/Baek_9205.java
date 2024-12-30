package bfs;

import java.io.*;
import java.util.*;

public class Baek_9205 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int t, n, beerCnt, target;
    static int[] current = new int[2];
    static int[] end = new int[2];
    static int[][] stores;
    static boolean[] visited;
    static Queue<int[]> q;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_9205.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            stores = new int[n][2];
            visited = new boolean[n];

            st = new StringTokenizer(br.readLine());
            current[0] = Integer.parseInt(st.nextToken());
            current[1] = Integer.parseInt(st.nextToken());
            for(int i = 0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                stores[i][0] = Integer.parseInt(st.nextToken());
                stores[i][1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            q = new LinkedList<>();
            q.add(new int[]{current[0],current[1]});
            flag = false;
            while(!q.isEmpty()){
                current = q.poll();

                for(int i = 0; i < stores.length; i++)
                    if((Math.abs(stores[i][0] - current[0]) + Math.abs(stores[i][1] - current[1])) <= 1000){
                        if(!visited[i]){
                            visited[i] = true;
                            q.add(new int[]{stores[i][0], stores[i][1]});
                        }
                    }

                if((Math.abs(end[0] - current[0]) + Math.abs(end[1] - current[1])) <= 1000){
                    flag = true;
                    break;
                }
            }
            sb.append(flag?"happy\n":"sad\n");
        }
        System.out.println(sb);
    }
}
