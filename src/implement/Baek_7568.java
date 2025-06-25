package implement;

import java.util.*;
import java.io.*;

// 7568
public class Baek_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            heights[i] = Integer.parseInt(st.nextToken());
            weights[i] = Integer.parseInt(st.nextToken());
        }
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (weights[j] > weights[i] && heights[j] > heights[i]) {
                    rank[i]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(rank[i]).append(" ");
        }
        System.out.println(sb);
    }
}
