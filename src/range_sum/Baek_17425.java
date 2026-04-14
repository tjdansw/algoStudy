package range_sum;

import java.io.*;

// 17425
public class Baek_17425 {
    static final int SIZE = 1_000_000;
    static long[] divisorSum = new long[SIZE+1];
    static long[] subSum = new long[SIZE+1];
    static{
        for (int i = 1; i <= SIZE; i++) {
            for (int number = i; number <= SIZE; number+=i) {
                divisorSum[number]+=i;
            }
        }
        for (int i = 1; i <= SIZE; i++) {
            subSum[i] = subSum[i-1]+divisorSum[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer answer = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int num = Integer.parseInt(br.readLine());
            answer.append(subSum[num]).append('\n');
        }
        System.out.println(answer);
    }
}
