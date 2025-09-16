package twopointer;

import java.util.*;
import java.io.*;

// 3649
// 1,000,000 나노미터 == 1 mm
public class Baek_3649 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line=br.readLine())!=null){
            int x = Integer.parseInt(line)*1_000_000*10;
            int n = Integer.parseInt(br.readLine());
            int[] lego = new int[n];
            for (int i = 0; i < n; i++) {
                lego[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(lego);
            int l=0, r=n-1;
            int l1 = -1, l2 = -1;
            while(l<r){
               int sumLen = lego[l]+lego[r];
               if(sumLen==x){
                   l1 = lego[l];
                   l2 = lego[r];
                   break;
               }else if(sumLen>x){
                   r--;
               }else{
                   l++;
               }
            }
            if(l1!=-1){
                sb.append("yes ").append(l1).append(' ').append(l2).append('\n');
            }else{
                sb.append("danger\n");
            }
        }
        System.out.println(sb);
    }
}
