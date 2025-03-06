package implement;

import java.io.*;
import java.util.*;

public class Baek_20055 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, k, start, step=0;
    static int[] belt;
    static boolean[] robot;



    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_20055.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        belt = new int[2 * n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) belt[i] = Integer.parseInt(st.nextToken());

        robot = new boolean[n];
        start = 0;

        while(k>0) {
            step++;

            start = (start - 1 + 2 * n) % (2 * n);

            for (int i = n - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            if (robot[n - 1]) {
                robot[n - 1] = false;
            }

            for (int i = n - 2; i >= 0; i--) {
                int nextPosition = (start + i + 1) % (2 * n);
                if (robot[i] && !robot[i + 1] && belt[nextPosition] > 0) {
                    robot[i] = false;
                    robot[i + 1] = true;
                    belt[nextPosition]--;
                    if (belt[nextPosition] == 0) k--;
                }
            }

            if (robot[n - 1]) {
                robot[n - 1] = false;
            }

            if (belt[start] > 0) {
                robot[0] = true;
                belt[start]--;
                if (belt[start] == 0) k--;
            }
        }

        System.out.println(step);
    }
}
