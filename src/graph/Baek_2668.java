package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Baek_2668 {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n;

    static int[] nums = new int[101];
    static boolean[] visited = new boolean[101];
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 1; i <= n; i++){
            if(visited[i]){
                continue;
            }
            cycleCheck(i, new int[n+1]);
        }
        sb.append(set.size()).append("\n");
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for(int i : list){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    public static void cycleCheck(int i, int[] checked){
        visited[i] = true;
        if(checked[i] < 2){
            checked[i]++;
            cycleCheck(nums[i], checked);
        }else if(checked[i] == 2){
            set.add(i);
            checked[i]++;
            cycleCheck(nums[i], checked);
        }
    }
}
