package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baek_15666 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static HashSet<Integer> set = new HashSet<>();
    static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) set.add(Integer.parseInt(st.nextToken()));
        list = new ArrayList<>(set);
        Collections.sort(list);
        dfs(0,0,new int[m]);
        System.out.println(sb);
    }

    static void dfs(int start,int dept, int[] nums) {
        if (dept>= m) {
            for(int i : nums) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }
        if(start>=list.size()) return;
        for(int i =start;i<list.size();i++) {
            nums[dept] = list.get(i);
            dfs(i,dept+1,nums);
        }
    }
}
