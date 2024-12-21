package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_11399 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n, prev = 0, total = 0;
    static int[] people;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_11399.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        people = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(people);

        for(int i = 0; i < n; i++) {
            total += prev + people[i];
            prev = prev + people[i];
        }
        System.out.println(total);
    }
}
