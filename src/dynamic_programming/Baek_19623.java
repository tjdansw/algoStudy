package dynamic_programming;

import java.util.*;
import java.io.*;

// 19623
public class Baek_19623 {
    static int n;
    static Meeting[] meetings;
    static long[] dp;

    static class Meeting{
        int start, end, numberOfPeople;

        public Meeting(int start, int end, int numberOfPeople) {
            this.start = start;
            this.end = end;
            this.numberOfPeople = numberOfPeople;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        meetings = new Meeting[n + 1];
        dp = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int numberOfPeople = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end, numberOfPeople);
        }

        Arrays.sort(meetings, 1, n + 1, (a, b) -> {
            if (a.end != b.end) return Integer.compare(a.end, b.end);
            return Integer.compare(a.start, b.start);
        });

        int[] ends = new int[n + 1];
        for (int i = 1; i <= n; i++) ends[i] = meetings[i].end;

        for (int i = 1; i <= n; i++) {
            int p = findPrevIndex(ends, meetings[i].start, i - 1);
            long take = dp[p] + meetings[i].numberOfPeople;
            long skip = dp[i - 1];
            dp[i] = Math.max(skip, take);
        }

        System.out.println(dp[n]);
    }

    static int findPrevIndex(int[] ends, int start, int hi) {
        int lo = 1;
        int ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (ends[mid] <= start) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}