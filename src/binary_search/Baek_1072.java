package binary_search;

import java.util.*;
import java.io.*;

// 1072
public class Baek_1072 {
    static long x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());
        long winnerPercent = y*100/x;
        if(winnerPercent==100||winnerPercent==99){
            System.out.println(-1);
            return;
        }
        long l = 0, r = x;
        while (l<=r){
            long mid = (l+r)/2;
            long percent = (y+mid)*100/(x+mid);

            if(percent>winnerPercent){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        System.out.println(l);
    }
}
