package implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_18222 {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static long k;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Long.parseLong(br.readLine());

        arr = new long[64];
        arr[0] = 1;
        for (int i = 1; i < 64; i++){
            arr[i] = arr[i-1] * 2;
        }
        System.out.println(check(k));
    }
    public static int check(long x){
        if (x == 1) return 0;
        for (int i = 0; i < 64; i++){
            if (arr[i] >= x) return 1 - check(x - arr[i-1]);
        }
        return 0;
    }

}