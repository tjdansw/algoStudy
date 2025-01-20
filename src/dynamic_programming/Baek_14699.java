package dynamic_programming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_14699 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static ArrayList<Mountain> list = new ArrayList<>();
    static int[] mountainArr;
    static int[] dp;
    static HashSet<Integer>[] load;
    static class Mountain {
        int index;
        int height;

        public Mountain(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_14699.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        mountainArr=new int[n+1];
        dp = new int[n+1];
        load = new HashSet[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            load[i] = new HashSet<>();
            mountainArr[i]=Integer.parseInt(st.nextToken());
            list.add(new Mountain(i, mountainArr[i]));
        }
        Collections.sort(list,new Comparator<Mountain>() {
            @Override
            public int compare(Mountain o1, Mountain o2) {
                return Integer.compare(o2.height, o1.height);
            }
        });
        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(mountainArr[a]>mountainArr[b]){
                load[b].add(a);
            }else {
                load[a].add(b);
            }
        }
        for(Mountain m : list){
            dp[m.index]=1;
            for(Integer i : load[m.index]){
                dp[m.index] = Math.max(dp[m.index], dp[i]+1);
            }
        }
        for(int i = 1; i <= n; i++)sb.append(dp[i]).append("\n");
        System.out.println(sb);
    }
}
