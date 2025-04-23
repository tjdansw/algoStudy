package math;

import java.io.*;
import java.util.*;

/**
 * 합성된 V자 모양의 볼록 함수 => 최솟값은 중앙값(median)에서 도출
 *
 * 1. 변수들
 *    - maxHeap (lower half, 최대힙)  
 *    - minHeap (upper half, 최소힙)
 *    - sumL = lower half 원소들의 합
 *    - sumR = upper half 원소들의 합
 *    - totalY = 지금까지 누적된 모든 (y_j) 의 합
 *
 * 2. 쿼리 1: (x,y) 가 들어오면
 *    1. totalY += y
 *    2. x 를
 *       - maxHeap 이 비었거나 x ≤ maxHeap.peek() 이면 maxHeap 에 넣고 sumL += x
 *       - 아니면 minHeap 에 넣고 sumR += x
 *    3. 균형 맞추기
 *       - 만약 maxHeap.size() > minHeap.size()+1 이면
 *
 *         int v = maxHeap.poll();
 *         sumL -= v;
 *         minHeap.add(v);
 *         sumR += v;
 *
 *       - 반대로 maxHeap.size() < minHeap.size() 면
 *
 *         int v = minHeap.poll();
 *         sumR -= v;
 *         maxHeap.add(v);
 *         sumL += v;
 *
 *
 * 3. 쿼리 2 (최솟값 위치·값 출력)
 *    - 최솟값을 내는 가장 작은 인덱스 (m) 은 lower half의 최댓값, 즉 maxHeap.peek()
 *    - 그때 합산된 거리값
 *       (m×∣L∣−sumL)+(sumR−m×∣R∣)+totalY : O(1) 연산
 *
 * 시간복잡도: O(qlog q)
 */
public class Baek_32036 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int q = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		long sumL = 0, sumR = 0, totalY = 0;

		for (int i = 0; i < q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			if (order == 1) {
				int x = Integer.parseInt(st.nextToken());
				long y = Long.parseLong(st.nextToken());
				totalY += y;

				if (maxHeap.isEmpty() || x <= maxHeap.peek()) {
					maxHeap.add(x);
					sumL += x;
				} else {
					minHeap.add(x);
					sumR += x;
				}

				if (maxHeap.size() > minHeap.size() + 1) {
					int v = maxHeap.poll();
					sumL -= v;
					minHeap.add(v);
					sumR += v;
				} else if (maxHeap.size() < minHeap.size()) {
					int v = minHeap.poll();
					sumR -= v;
					maxHeap.add(v);
					sumL += v;
				}
			} else {
				int m = maxHeap.peek();
				long leftCost = m * (long)maxHeap.size() - sumL;
				long rightCost = sumR - m * (long)minHeap.size();
				long result = leftCost + rightCost + totalY;
				sb.append(m).append(" ").append(result).append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}
