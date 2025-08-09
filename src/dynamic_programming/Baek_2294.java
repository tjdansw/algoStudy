package dynamic_programming;

import java.util.*;
import java.io.*;

// 2294
public class Baek_2294 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        TreeSet<Integer> coins = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }
        int[] value = new int[k+1];
        int max = k+1;
        Arrays.fill(value, max);
        value[0] = 0;
        for(int coin : coins){
            if(coin > k){
                break;
            }
            for(int current = coin; current <= k; current++){
                if(value[current-coin] == max){
                    continue;
                }
                value[current] = Math.min(value[current], value[current-coin] + 1);
            }
        }
        System.out.println(value[k]==max?-1:value[k]);
    }
}

