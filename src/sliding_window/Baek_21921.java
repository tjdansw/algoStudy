package sliding_window;

import java.util.*;
import java.io.*;

// 21921
public class Baek_21921 {
    static int n, x;
    static int[] subSumByVisitantCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        subSumByVisitantCnt = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            subSumByVisitantCnt[i] = subSumByVisitantCnt[i-1]+Integer.parseInt(st.nextToken());
        }
        int max = 0;
        int cnt = 0;
        for (int i = x; i <= n; i++) {
            int visitantCnt = subSumByVisitantCnt[i]-subSumByVisitantCnt[i-x];
            if(max<visitantCnt){
                max = visitantCnt;
                cnt = 1;
            }else if(max == visitantCnt){
                cnt++;
            }
        }
        if(max==0){
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(cnt);
    }
}
