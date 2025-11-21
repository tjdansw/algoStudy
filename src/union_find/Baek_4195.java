package union_find;

import java.util.*;
import java.io.*;

// 4195
public class Baek_4195 {
    static int n, idx;
    static int[] parent;
    static int[] groupCnt;
    static HashMap<String, Integer> userIds = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            init();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String aName = st.nextToken();
                String bName = st.nextToken();
                int aId = getUserId(aName);
                int bId = getUserId(bName);
                union(aId, bId);
                sb.append(groupCnt[parent[aId]]).append('\n');
            }
        }
        System.out.println(sb);
    }

    static int getUserId(String name){
        if(!userIds.containsKey(name)){
            userIds.put(name, idx++);
        }
        return userIds.get(name);
    }

    static void init(){
        idx = 0;
        userIds.clear();
        parent = new int[2*n];
        groupCnt = new int[2*n];
        for (int i = 0; i < 2*n; i++) {
            parent[i] = i;
            groupCnt[i] = 1;
        }
    }

    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b){
        int pA = find(a);
        int pB = find(b);

        if(pA==pB) return false;
        parent[pB] = pA;
        groupCnt[pA] += groupCnt[pB];
        return true;
    }
}
