package dynamic_programming;

import java.util.*;
import java.io.*;

// 9184
public class Baek_9184 {
    static int[][][] dp = new int[21][21][21];
    static{
        for(int i = 0; i < 21; i++){
            for(int j = 0; j < 21; j++){
                for(int k = 0; k < 21; k++){
                    if(i*j*k==0){
                        dp[i][j][k] = 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a, b, c;
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a==-1 && b==-1 && c==-1){
                break;
            }
            sb.append(String.format("w(%d, %d, %d) = ", a, b, c));
            a = Math.max(a,0);
            b = Math.max(b,0);
            c = Math.max(c,0);
            if(a<=0||b<=0||c<=0){
                sb.append("1\n");
                continue;
            }
            if(a>20||b>20||c>20){
                a = 20;
                b = 20;
                c = 20;
            }
            sb.append(w(a, b, c)).append("\n");
        }
        System.out.println(sb);
    }

    private static int w(int a, int b, int c){
        if(dp[a][b][c]!=0){
            return dp[a][b][c];
        }
        if(a<b&&b<c){
            dp[a][b][c] = w(a,b,Math.max(c-1,0))
                    + w(a,Math.max(b-1,0),Math.max(c-1,0))
                    - w(a,Math.max(b-1,0),c);
        }else{
            dp[a][b][c] = w(Math.max(a-1,0),b,c)
                    + w(Math.max(a-1,0),Math.max(b-1,0), c)
                    + w(Math.max(a-1,0), b, Math.max(c-1,0))
                    - w(Math.max(a-1,0), Math.max(b-1,0), Math.max(c-1,0));
        }
        return dp[a][b][c];
    }
}
