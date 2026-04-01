package binary_search;

import java.io.*;

// 3066
public class Baek_3066 {
    static int n;
    static int[] lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            n = Integer.parseInt(br.readLine());
            lis = new int[n];
            int len = 0;
            for (int i = 1; i <= n; i++) {
                int num = Integer.parseInt(br.readLine());
                int l = 0, r = len;
                while (l<r){
                    int mid = (l+r)/2;

                    if(lis[mid]<num){
                        l = mid+1;
                    }else{
                        r = mid;
                    }
                }
                lis[l] = num;
                if(l==len) len++;
            }
            System.out.println(len);
        }
        System.out.println(answer);
    }
}
