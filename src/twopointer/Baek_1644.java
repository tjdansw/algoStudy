package twopointer;

import java.io.*;

public class Baek_1644 {
    static int n, cnt = 0;
    static int[] decimal = new int[500_000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int idx = 1;
        decimal[0] = 2;
        for(int i = 3;i<=n;i+=2){
            if(isDecimal(i)){
                decimal[idx++] = i;
            }
        }
        int start = 0, end = 0, sum = 0;
        while (true) {
            if (sum >= n) sum -= decimal[start++];
            else if (end == idx) break;
            else sum += decimal[end++];
            if (sum == n) cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean isDecimal(int num){
        for(int i = 2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
