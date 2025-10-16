package dynamic_programming;

import java.util.*;
import java.io.*;

// 2411
public class Baek_2411 {
    static int n, m, a, b;
    static int[][] map, dp;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static ArrayList<int[]> items = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        dp = new int[n+1][m+1];

        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            items.add(new int[]{x, y});
        }
        items.add(new int[]{1, 1});
        items.add(new int[]{n, m});
        Collections.sort(items, (o1, o2)-> {
            if(o1[0]==o2[0]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        });
        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = -1;
        }

        dp[1][1] = 1;
        for (int i = 1; i < items.size(); i++) {
            int[] start = items.get(i-1);
            int[] end = items.get(i);
            moveCnt(start, end);
        }
        System.out.println(dp[n][m]);
    }

    static boolean isBound(int x, int y){
        return x>0&&x<=n&&y>0&&y<=m;
    }

    static void moveCnt(int[] start, int[] end){
        for (int i = start[1]; i <= end[1]; i++) {
            for (int j = start[0]; j <= end[0]; j++) {
                if(i==start[1]&&j==start[0]) continue;
                for (int k = 0; k < 2; k++) {
                    int px = j - dx[k];
                    int py = i - dy[k];
                    if(isBound(px, py)&&px>=start[0]&&py>=start[1]&&map[px][py]!=-1){
                        dp[j][i] += dp[px][py];
                    }
                }
            }
        }
    }
}
