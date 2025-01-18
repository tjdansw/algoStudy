package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baek_1015 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static ArrayList<int[]> list = new ArrayList<>();
    static int[] result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_1015.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            list.add(new int[]{Integer.parseInt(st.nextToken()), i});
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        result = new int[n];
        int idx = 0;
        for(int[] arr : list) result[arr[1]] = idx++;
        for(int i = 0; i < n; i++) sb.append(result[i]).append(" ");
        System.out.println(sb);
    }
}
