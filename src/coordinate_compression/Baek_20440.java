package coordinate_compression;

import java.util.*;
import java.io.*;

// 20440
/**
 * 1. 입력받은 모기 활동 구간을 intervals 배열에 저장
 *    시작 시간과 종료 시간을 TreeSet에 모두 저장하여 중복 제거 및 정렬
 *
 * 2. TreeSet을 기반으로 좌표 압축
 *    → 시간 단위가 클 수 있으므로, 시간 값을 연속된 인덱스로 변환
 *
 * 3. 차분 배열(delta)을 생성하여
 *    - 시작 시점에 +1
 *    - 종료 시점에 -1
 *    를 기록하여 시간 변화만 반영
 *
 * 4. delta 배열을 누적합하여
 *    각 시간 구간별 모기 수 배열(mosquito)을 구성
 *
 * 5. 최대 모기 수(max)를 계산한 후,
 *    해당 모기 수가 유지되는 구간의 시작/끝 인덱스를 탐색
 *
 * 6. 압축된 인덱스를 원래 시간으로 되돌리기 위해 indexToTime을 활용
 *    최종적으로 최대 모기 수와 해당 시간 구간을 출력
 */
public class Baek_20440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] intervals = new int[n][2];
        TreeSet<Integer> timePoints = new TreeSet<>();
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            intervals[i][0] = start;
            intervals[i][1] = end;
            timePoints.add(start);
            timePoints.add(end);
        }

        HashMap<Integer, Integer> timeToIndex = new HashMap<>();
        HashMap<Integer, Integer> indexToTime = new HashMap<>();
        int idx = 0;
        for (int time : timePoints) {
            timeToIndex.put(time, idx);
            indexToTime.put(idx, time);
            idx++;
        }

        int[] delta = new int[idx + 1];
        for (int[] interval : intervals) {
            int s = timeToIndex.get(interval[0]);
            int e = timeToIndex.get(interval[1]);
            delta[s]++;
            delta[e]--;
        }

        int[] mosquito = new int[idx];
        mosquito[0] = delta[0];
        int max = mosquito[0];
        for (int i = 1; i < idx; i++) {
            mosquito[i] = mosquito[i - 1] + delta[i];
            max = Math.max(max, mosquito[i]);
        }

        int start = -1, end = -1;
        boolean active = false;
        for (int i = 0; i < idx; i++) {
            if (mosquito[i] == max && !active) {
                start = i;
                active = true;
            }
            if (active && (i == idx - 1 || mosquito[i + 1] < max)) {
                end = i;
                break;
            }
        }

        System.out.println(max);
        System.out.println(indexToTime.get(start) + " " + indexToTime.get(end + 1));
    }
}
