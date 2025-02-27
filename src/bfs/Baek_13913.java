package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_13913 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n, k, cnt = 0;
    static int[][] derivation = new int[100001][2];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        for(int i=0; i<100001; i++) derivation[i][0]=-1;
        derivation[k][0]=k;
        while (!q.isEmpty()) {
            int current = q.poll();

            if(current==n){
                System.out.println(derivation[current][1]);
                break;
            }

            if (current != 0 && current%2==0&& current / 2 <= 50000 && derivation[current / 2][0]== -1) {
                derivation[current / 2][0] = current;
                derivation[current / 2][1] = derivation[current][1]+1;
                q.add(current/2);
            }
            if (current < 100000 && derivation[current + 1][0]==-1) {
                derivation[current + 1][0] = current;
                derivation[current + 1][1] = derivation[current][1]+1;
                q.add(current+1);
            }
            if (current > 0 && derivation[current - 1][0]==-1) {
                derivation[current - 1][0] = current;
                derivation[current - 1][1] = derivation[current][1]+1;
                q.add(current-1);
            }
        }
        int current = n;
        sb.append(current);
        while(current!=k){
            current = derivation[current][0];
            sb.append(" ").append(current);
        }
        System.out.println(sb);
    }
}