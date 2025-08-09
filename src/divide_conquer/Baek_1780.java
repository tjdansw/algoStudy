package divide_conquer;

import java.util.*;
import java.io.*;

// 1780
public class Baek_1780 {
    static int n;
    static int[][] map;
    static int[] cnt = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken())+1;
            }
        }
        divideConquer(0,0,n);
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<3;i++){
            sb.append(cnt[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void divideConquer(int sR, int sC, int len){
        boolean isSame = true;
        int flag = map[sR][sC];
        for(int i = 0;i<len&&isSame;i++){
            for(int j = 0;j<len&&isSame;j++){
                if(map[sR+i][sC+j]!=flag){
                    isSame = false;
                }
            }
        }
        if(isSame){
            cnt[flag]++;
            return;
        }
        if(len>1){
            int term = len/3;
            for(int i = 0;i<len;i+=term){
                for(int j = 0;j<len;j+=term){
                    divideConquer(sR+i,sC+j,term);
                }
            }
        }
    }
}
