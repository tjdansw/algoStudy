package binary_search;

import java.util.*;
import java.io.*;

// 8983
public class Baek_8983 {
    static int m, n, l;
    static int[] gunCoordinates;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // m : 총 사대 수, n : 동물 수, l : 사격 가능 거리
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        gunCoordinates = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<m;i++) gunCoordinates[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(gunCoordinates);

        int cnt = 0;
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(y>l) continue;

            int left = 0, right = m-1;
            while (left <= right){
                int mid = (left + right)/2;
                int len = Math.abs(x-gunCoordinates[mid])+y;
                if(len <= l){
                    cnt++;
                    break;
                }
                if(x<=gunCoordinates[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }

        }

        System.out.println(cnt);
    }
}
