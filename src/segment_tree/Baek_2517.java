package segment_tree;

import java.util.*;
import java.io.*;

// 2517
public class Baek_2517 {
    static int n;
    static int[] bit;
    static int[] skillValue, compSkillValue;
    static HashMap<Integer, Integer> compMap = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        skillValue = new int[n];
        compSkillValue = new int[n];
        for (int i = 0; i < n; i++) {
            skillValue[i] = Integer.parseInt(br.readLine());
        }

        int[] sort = skillValue.clone();
        Arrays.sort(sort);
        for(int i = 0; i<n;i++){
            compMap.put(sort[i],i+1);
        }
        for(int i = 0; i<n;i++){
            compSkillValue[i] = compMap.get(skillValue[i]);
        }

        StringBuilder sb = new StringBuilder();
        bit = new int[n + 2];
        for (int i = 0; i < n; i++) {
            int c = compSkillValue[i];

            int weakerCount = sum(c - 1);

            int bestRank = (i + 1) - weakerCount;

            sb.append(bestRank).append('\n');

            update(c, 1);
        }

        System.out.print(sb.toString());
    }

    static int sum(int idx) {
        int ret = 0;
        while (idx > 0) {
            ret += bit[idx];
            idx -= (idx & -idx);
        }
        return ret;
    }

    static void update(int idx, int val) {
        while (idx <= n) {
            bit[idx] += val;
            idx += (idx & -idx);
        }
    }
}
