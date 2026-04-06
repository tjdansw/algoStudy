package range_sum;

import java.util.*;
import java.io.*;

// 2015
public class Baek_2015 {
    static int n;
    static long k;
    static long[] subSum;
    static HashMap<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());
        subSum = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            subSum[i] = subSum[i-1]+Long.parseLong(st.nextToken());;
        }

        long answer = 0;
        map.put(0L, 1L);
        for (int i = 1; i <= n; i++) {
            answer += map.getOrDefault(subSum[i]-k, 0L);
            map.put(subSum[i], map.getOrDefault(subSum[i],0L)+1);
        }

        System.out.println(answer);
    }
}
