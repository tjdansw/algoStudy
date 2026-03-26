package brute_force;

import java.util.*;
import java.io.*;

// 1038
public class Baek_1038 {
    static int n;
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (long i = 9; i >= 0; i--) {
            dfs(i, i);
        }
        Collections.sort(list);
        n = Integer.parseInt(br.readLine());
        if(list.size()>n){
            System.out.println(list.get(n));
        }else{
            System.out.println(-1);
        }
    }

    static void dfs(long lastNum, long value){
        list.add(value);
        for (long i = lastNum-1; i >= 0; i--) {
            dfs(i, value*10+i);
        }
    }

}
