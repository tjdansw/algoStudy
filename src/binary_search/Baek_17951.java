package binary_search;

import java.util.*;
import java.io.*;

/*
    BOJ 17951
    이분 탐색 + 그리디

    이분 탐색 대상: 각 그룹 점수의 최솟값
    왼쪽부터 누적합을 더해 누적합 >= mid 가 되는 순간 그룹 하나 확정
    mid 이상 그룹을 최대한 많이 만든다(왜 k개 이상? 최소만 충족하면 k+1번 이상의 그룹은 배분하면 되므로)
    그 결과 그룹 수 >= K 이면 mid는 가능한 값

    시간복잡도: O(N log(sum))
*/
public class Baek_17951 {
    static int n, k;
    static int[] scores;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        scores = new int[n];
        st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            total += scores[i];
        }

        int l = 0, r = total;
        int answer = 0;

        while (l <= r) {
            int mid = (l + r)/2;
            if (canMake(mid)) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static boolean canMake(int minScore) {
        int cnt = 0;
        int sum = 0;
        for (int x : scores) {
            sum += x;
            if (sum >= minScore) {
                cnt++;
                sum = 0;
            }
        }
        return cnt >= k;
    }
}