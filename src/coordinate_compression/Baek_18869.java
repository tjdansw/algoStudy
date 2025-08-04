package coordinate_compression;

import java.util.*;
import java.io.*;

// 18869

/**
 * 제약 사항
 * - 2 <= m <= 100, 3 <= n <= 10,000, 1 <= 행성의 크기 <= 1,000,000
 *
 * 풀이
 * 1. 데이터 입력
 * 2. 각 행성에 대해 상대적인 크기 순서를 구하기(값 압축)
 *  - [30, 10, 20] → 정렬 후 순위 매핑 → [2, 0, 1]
 * 3. 상대적 순서 배열이 동일한 행성 쌍을 찾기
 *  - 순서 배열을 문자열로 변환하여 Map에 빈도수 저장
 * 4. 동일한 구조의 행성이 v개일 때, 쌍의 수는 vC2 = v*(v-1)/2
 * 5. 모든 key에 대해 쌍의 수를 누적합하여 출력
 */
public class Baek_18869 {
    static int n, m;
    static int[][] planets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        planets = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];
            HashMap<Integer,Integer> rank = new HashMap<>();
            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
                b[j] = a[j];
            }
            Arrays.sort(b);
            int idx = 0;
            for (int j = 0; j < n; j++) {
                if(!rank.containsKey(b[j])){
                    rank.put(b[j],idx++);
                }
            }
            for (int j = 0; j < n; j++) {
                planets[i][j] = rank.get(a[j]);
            }
        }

        HashMap<String,Integer> map = new HashMap<>();
        for(int[] planet : planets) {
            String key = Arrays.toString(planet);
            map.put(key,map.getOrDefault(key,0)+1);
        }

        int cnt = 0;
        for(int value : map.values()){
            if(value == 1){
                continue;
            }
            cnt += (value*(value - 1))/2;
        }

        System.out.println(cnt);
    }
}
