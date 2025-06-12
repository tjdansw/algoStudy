package divide_conquer;

import java.io.*;
import java.util.StringTokenizer;

//10830
public class Baek_10830 {
    static final int MOD = 1000;
    static int n;
    static long b;
    static int[][] adj;


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());

        adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken())%MOD;
            }
        }

        int[][] result = adjPow(adj,b);
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int[][] adjPow(int[][] a, long p) {
        if(p == 1){
            return a;
        }
        int[][] subResult = adjPow(a,p/2);

        subResult = adjMultiply(subResult,subResult);
        if(p%2==1){
            subResult = adjMultiply(subResult,adj);
        }

        return subResult;
    }

    private static int[][] adjMultiply(int[][] a, int[][] b) {
        int[][] result = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                for(int k = 0;k<n;k++){
                    result[i][j] += a[i][k] * b[k][j];
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }
}
