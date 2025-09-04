package greedy;

import java.util.*;
import java.io.*;

// 30805
public class Baek_30805 {
    static int n, m;
    static int[] aList, bList;

    static int lowerBound(List<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr.get(mid) < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        aList = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) aList[i] = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        bList = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) bList[i] = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> posA = new HashMap<>();
        Map<Integer, List<Integer>> posB = new HashMap<>();

        for (int i = 0; i < n; i++) {
            posA.computeIfAbsent(aList[i], k -> new ArrayList<>()).add(i);
        }
        for (int j = 0; j < m; j++) {
            posB.computeIfAbsent(bList[j], k -> new ArrayList<>()).add(j);
        }

        ArrayList<Integer> values = new ArrayList<>();
        for (int v : posA.keySet()) {
            if (posB.containsKey(v)) values.add(v);
        }
        values.sort(Comparator.reverseOrder());

        ArrayList<Integer> ans = new ArrayList<>();
        int ia = 0, jb = 0;

        while (true) {
            boolean picked = false;

            for (int v : values) {
                List<Integer> la = posA.get(v);
                List<Integer> lb = posB.get(v);
                int pa = lowerBound(la, ia);
                if (pa == la.size()) continue;
                int aIdx = la.get(pa);

                int pb = lowerBound(lb, jb);
                if (pb == lb.size()) continue;
                int bIdx = lb.get(pb);

                ans.add(v);
                ia = aIdx + 1;
                jb = bIdx + 1;
                picked = true;
                break;
            }
            if (!picked) break;
        }

        if (ans.isEmpty()) {
            System.out.println(0);
            return;
        }
        StringBuilder out = new StringBuilder();
        out.append(ans.size()).append("\n");
        for (int i = 0; i < ans.size(); i++) {
            if (i > 0) out.append(' ');
            out.append(ans.get(i));
        }
        System.out.println(out);
    }
}
