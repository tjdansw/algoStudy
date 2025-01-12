package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baek_11650 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_11650.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0]?Integer.compare(o1[1], o2[1]):Integer.compare(o1[0], o2[0]);
            }
        });
        for(int[] a : list) {
            sb.append(a[0]).append(" ").append(a[1]).append("\n");
        }
        System.out.println(sb);
    }
}
