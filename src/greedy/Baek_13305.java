package greedy;

import java.util.*;
import java.io.*;

// 13305
public class Baek_13305 {
    static int n;
    static long[] nodeInfo;
    static long[] loadLen;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nodeInfo = new long[n];
        loadLen = new long[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            loadLen[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nodeInfo[i] = Long.parseLong(st.nextToken());
        }


        long oilCost = 1_000_000_000;
        long spendingAmount = 0;

        for (int i = 0; i < n-1; i++) {
            oilCost = Math.min(oilCost, nodeInfo[i]);
            spendingAmount += oilCost*loadLen[i];
        }
        System.out.println(spendingAmount);
    }
}
