package dynamic_programming;

import java.io.*;

// 1958
public class Baek_1958 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] wordArray = {br.readLine().toCharArray(),br.readLine().toCharArray(),br.readLine().toCharArray()};
        int n = wordArray[0].length;
        int p = wordArray[1].length;
        int q = wordArray[2].length;
        int[][][] dp = new int[n+1][p+1][q+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=p;j++){
                for (int k = 1;k<=q;k++){
                    dp[i][j][k] = Math.max(Math.max(dp[i-1][j][k],dp[i][j-1][k]),dp[i][j][k-1]);
                    if(wordArray[0][i-1]==wordArray[1][j-1]&&wordArray[1][j-1]==wordArray[2][k-1]){
                        dp[i][j][k] = Math.max(dp[i][j][k],dp[i-1][j-1][k-1]+1);
                    }
                }
            }
        }
        System.out.println(dp[n][p][q]);
    }
}
