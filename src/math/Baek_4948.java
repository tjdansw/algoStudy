package math;

import java.io.*;

// 4948
public class Baek_4948 {
    static final int SIZE = 2*123_456+1;
    static boolean[] notPrime = new boolean[SIZE];
    static {
        notPrime[1] = true;
        for(int i=4; i<=SIZE; i+=2){
            notPrime[i] = true;
        }
        for(int i=3; i<=SIZE; i+=2){
            for(int j=2*i; j<=SIZE; j+=i){
                notPrime[j] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            int cnt = 0 ;
            for (int i = n+1; i < 2*n+1; i++) {
                if (!notPrime[i]) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
