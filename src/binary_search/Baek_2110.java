package binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_2110 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, c;
    static int[] house;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        house = new int[n];
        for(int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        int left = 1, right = house[n-1]-house[0]+1;
        int cnt = 2;
        while (left < right) {
            int mid = (left + right) / 2;
            int res = count(mid);

            if (res >= c) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(right - 1);
    }

    static int count(int gap) {
        int cnt = 1;
        int lastLocate = house[0];

        for (int i = 1; i < n; i++) {
            int locate = house[i];
            if (locate - lastLocate >= gap) {
                cnt++;
                lastLocate = locate;
            }
        }

        return cnt;
    }
}
