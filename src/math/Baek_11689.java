package math;

import java.io.*;

// 11689
/**
 * 오일러 p함수 사용
 * 모든 자연수 n은 소수들의 곱으로 표현 가능하다는 성질을 이용
 * φ(n) : n보다 작거나 같은 자연수 중에서 n과 서로소인 수의 개수
 * φ(n) = n * (1 - 1/p1) * (1 - 1/p2) * ... * (1 - 1/pk)
 * 여기서 p1, p2, ..., pk는 n의 서로 다른 소인수들(전부 소수)
 * 이를 통해 n의 각 소인수에 대해 φ(n)을 갱신하여 값을 계산
 * 시간 복잡도: O(root(n)) — n의 소인수 분해는 root(n)까지의 수만 검사
 */
public class Baek_11689 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long res = n;
        for(long i = 2;i*i<=n;i++){
            if(n%i==0){
                while(n%i==0){
                    n /= i;
                }
                res -= res/i;
            }
        }

        if (n > 1) {
            res -= res/n;
        }
        System.out.println(res);
    }
}
