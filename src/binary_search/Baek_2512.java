package binary_search;

import java.util.*;
import java.io.*;

// 2512
public class Baek_2512 {
    static int n, maxBudget;
    static int[] budgetOfCountry;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        budgetOfCountry = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = 1, r = 0;
        for (int i = 0; i < n; i++) {
            budgetOfCountry[i] = Integer.parseInt(st.nextToken());
            r = Math.max(r, budgetOfCountry[i]);
        }
        maxBudget = Integer.parseInt(br.readLine());

        while (l<=r){
            int mid = (l+r)/2;
            int total = 0;
            for (int i = 0; i < n; i++) {
                total += Math.min(budgetOfCountry[i], mid);
            }
            if(total<=maxBudget){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        System.out.println(r);
    }
}
