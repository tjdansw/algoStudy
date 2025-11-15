package twopointer;

import java.io.*;

// 2018
public class Baek_2018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        int cnt = 0;
        long l = 0, r = 1;
        while (l<n){
            long subSum = (r*(r+1))/2 - (l*(l+1))/2;
            if(subSum<=n){
                if(subSum==n) {
                    cnt++;
                }
                r++;
            }else{
                l++;
            }
        }
        System.out.println(cnt);
    }
}
