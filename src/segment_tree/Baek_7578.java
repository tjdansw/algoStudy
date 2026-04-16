package segment_tree;

import java.util.*;
import java.io.*;

// 7578
public class Baek_7578 {
    static int n;
    static HashMap<Integer, Integer> indexMap = new HashMap<>();
    static int[] indexOfNumber, temp;

    static class Fenwick {
        int n;
        long[] tree;

        Fenwick(int n) {
            this.n = n;
            this.tree = new long[n + 1];
        }

        void update(int i, long diff) {
            while (i <= n) {
                tree[i] += diff;
                i += i & -i;
            }
        }

        long sum(int i) {
            long res = 0;
            while (i > 0) {
                res += tree[i];
                i -= i & -i;
            }
            return res;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        indexOfNumber = new int[n];
        temp = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            indexMap.put(num, i+1);
        }

        for (int i = 0; i < n; i++) {
            indexOfNumber[i] = indexMap.get(temp[i]);
        }

        Fenwick fenwick = new Fenwick(n);
        long answer = 0;
        for (int i = 0; i < n; i++) {
            int x = indexOfNumber[i];
            answer += i - fenwick.sum(x);
            fenwick.update(x, 1);
        }

        System.out.println(answer);
    }
}
