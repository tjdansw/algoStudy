package dynamic_programming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1082
public class Baek_1082 {
    static int n, m;
    static int[] p;
    static Number[] dp;

    static class Number {
        int[] numCnt = new int[10];

        public void update(Number prev, int num) {
            for(int i = 0; i < 10; i++) {
                numCnt[i] = prev.numCnt[i];
            }
            numCnt[num]++;
        }

        public String getMaxValue() {
            StringBuilder sb = new StringBuilder();
            boolean flag = true;
            for (int i = 9; i >= 0; i--) {
                if(numCnt[i] == 0) {
                    continue;
                }
                if(i>0){
                    flag = false;
                }
                for(int j = 0; j < numCnt[i]; j++) {
                    sb.append(i);
                }
            }
            return flag?"0":sb.toString();
        }

        public String compareValue(int k) {
            StringBuilder sb = new StringBuilder();
            boolean flag = true;
            for (int i = 9; i >= 0; i--) {
                if(i!=k&&numCnt[i] == 0) {
                    continue;
                }
                if(i>0){
                    flag = false;
                }
                for(int j = 0; j < numCnt[i]; j++) {
                    sb.append(i);
                }
                if(i==k){
                    sb.append(i);
                }
            }
            return flag?"0":sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        p = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        dp = new Number[m+1];
        for(int i = 0; i < m+1; i++) {
            dp[i] = new Number();
        }

        for(int i = 1;i<=m;i++){
            for(int j = 0;j<n;j++){
                int prev =i-p[j];
                if(prev<0) continue;
                if(compareString(dp[prev].compareValue(j), dp[i].getMaxValue())){
                    dp[i].update(dp[prev],j);
                }
            }
        }

        String max = "0";
        for(int i = m;i>0;i--){
            if(compareString(dp[i].getMaxValue(), max)){
                max = dp[i].getMaxValue();
            }
        }
        System.out.println(max);
    }

    private static boolean compareString(String a, String b) {
        if (a.length() > b.length()) return true;
        if (a.length() < b.length()) return false;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == b.charAt(i)){
                continue;
            }
            return a.charAt(i)>b.charAt(i);
        }
        return false;
    }
}
