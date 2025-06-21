package implement;

import java.util.*;
import java.io.*;

// 18111
public class Baek_18111 {
    static int n, m, b;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        int minH = Integer.MAX_VALUE;
        int maxH = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, map[i][j]);
                minH = Math.min(minH, map[i][j]);
            }
        }

        int goalHeight = 0;
        int minTime = Integer.MAX_VALUE;

        for (int height = minH; height <= maxH; height++) {
            int blockCnt = b;
            int time = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] > height) {
                        time += 2 * (map[i][j] - height);
                        blockCnt += map[i][j] - height;
                    } else if (map[i][j] < height) {
                        time += height - map[i][j];
                        blockCnt -= height - map[i][j];
                    }
                }
            }
            if(blockCnt>=0&&minTime>=time) {
                minTime = time;
                goalHeight = height;
            }
        }

        System.out.println(minTime+" "+goalHeight);
    }
}

/*
누적합을 활용한 풀이
- 시간복잡도 O(H*257) = O(H) ( H: 최대 높이 - 최소 높이 )
import java.util.*;
import java.io.*;

public class Main {
    static int n, m, b;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        int minH = 256, maxH = 0;
        int[] heightCount = new int[257];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int h = Integer.parseInt(st.nextToken());
                map[i][j] = h;
                heightCount[h]++;
                minH = Math.min(minH, h);
                maxH = Math.max(maxH, h);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int goalHeight = 0;

        for (int h = minH; h <= maxH; h++) {
            int time = 0;
            int block = b;

            for (int i = 0; i <= 256; i++) {
                int diff = i - h;
                if (diff > 0) {
                    time += diff * 2 * heightCount[i];
                    block += diff * heightCount[i];
                } else if (diff < 0) {
                    time += (-diff) * heightCount[i];
                    block -= (-diff) * heightCount[i];
                }
            }

            if (block >= 0 && time <= minTime) {
                minTime = time;
                goalHeight = h;
            }
        }

        System.out.println(minTime + " " + goalHeight);
    }
}

 */