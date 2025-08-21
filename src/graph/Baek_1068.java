package graph;

import java.util.*;
import java.io.*;

// 1068
public class Baek_1068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent==-1) continue;
            tree[parent].add(i);
        }
        int deleteNode = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            if(tree[i] != null) {
                tree[i].remove(Integer.valueOf(deleteNode));
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(deleteNode);
        while (!q.isEmpty()) {
            int node = q.poll();
            for(int child : tree[node]) {
                q.add(child);
            }
            tree[node] = null;
        }
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(tree[i] == null) continue;
            if(tree[i].isEmpty()) cnt++;
        }
        System.out.println(cnt);
    }
}
