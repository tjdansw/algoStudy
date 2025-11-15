package twopointer;

import java.util.*;
import java.io.*;

// 1644
public class Baek_1644 {
    static boolean[] isNotPrime;
    static ArrayList<Integer> primeList = new ArrayList<>();
    static long[] subSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        isNotPrime = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            if(isNotPrime[i]) continue;
            primeList.add(i);
            for (int j = i*2; j <= n; j+=i) {
                isNotPrime[j] = true;
            }
        }

        subSum = new long[primeList.size()+1];
        for (int i = 0; i < primeList.size(); i++) {
            subSum[i+1] = subSum[i]+primeList.get(i);
        }

        int cnt = 0;
        int l = 0, r = 1;
        while (r<= primeList.size()){
            long rangeSum = subSum[r]-subSum[l];
            if(rangeSum<=n){
                if(rangeSum==n){
                    cnt++;
                }
                r++;
            }else{
                l++;
            }
        }
        System.out.println(cnt);
    }
}

