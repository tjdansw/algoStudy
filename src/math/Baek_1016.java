package math;

import java.util.*;
import java.io.*;

// 1016
/**
 * 풀이 방법
 * 1. 2부터 sqrt(b)까지의 수의 제곱값(i*i)을 기준
 * 2. 각 제곱수로 나누어 떨어지는 수들은 제곱수의 배수이므로 모두 제거
 *    - a 이상 b 이하에서 i*i의 배수인 수들 배제
 *    - 이때 i*i의 배수들 중 가장 작은 수는 (a + i*i - 1) / (i*i) * (i*i) 로 계산
 * 3. 이 범위에 있는 숫자들은 배열에서 표시
 * 4. 마지막에 표시되지 않은 숫자들의 개수 체크
 *
 * 시간복잡도:
 * - 루트 b까지 루프: O(√b)
 * - 각 제곱수마다 b-a 범위에서 마킹: 총 O(√b × (b-a)/i^2) ≈ O(√b)
 * - 최대 (b-a) ≤ 1,000,000
 *
 * 공간복잡도:
 * - boolean 배열 크기: b-a+1 (최대 1,000,001) → O(b-a)
 */
public class Baek_1016 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int n = (int)(b-a+1);
        boolean[] isSquareNum = new boolean[n];

        for(long i = 2;i*i<=b;i++){
            long square = i*i;
            long start = ((a+square-1)/square)*square;
            for(long j = start;j<=b;j+=square){
                int idx = (int)(j-a);
                isSquareNum[idx] = true;
            }
        }

        int cnt = 0;
        for(int i = 0;i<n;i++){
            if(!isSquareNum[i]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
