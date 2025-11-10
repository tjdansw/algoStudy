package greedy;

import java.util.*;
import java.io.*;

// 13164
public class Baek_13164 {
    static int n, k;
    static int[] heights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        heights = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        int[] term = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            term[i] = heights[i+1]-heights[i];
        }
        Arrays.sort(term);
        int answer = 0;
        for (int i = 0; i < n-k; i++) {
            answer += term[i];
        }
        System.out.println(answer);
    }
}
