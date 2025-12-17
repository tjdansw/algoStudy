package union_find;

import java.io.*;
import java.util.*;

// 24391
public class Baek_24391 {
    // 1 <= N <= 10_000, 0 <= M <= 10_000s
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        int currnet = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int next = Integer.parseInt(st.nextToken());
            if(find(currnet)!=find(next)){
                answer++;
            }
            currnet = next;
        }
        System.out.println(answer);
    }

    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b){
        int pA = find(a);
        int pB = find(b);

        if(pA==pB) return false;
        parent[pB] = pA;
        return true;
    }
}
