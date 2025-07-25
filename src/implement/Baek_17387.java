package implement;

import java.util.*;
import java.io.*;

// 17387
public class Baek_17387 {
    static class Coordinate{
        long x;
        long y;

        public Coordinate(StringTokenizer st) {
            x = Long.parseLong(st.nextToken());
            y = Long.parseLong(st.nextToken());
        }
    }
    static Coordinate[] points = new Coordinate[4];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;
        for(int i = 0; i < 4; i++) {
            if(i%2==0){
                st = new StringTokenizer(br.readLine());
            }
            points[i] = new Coordinate(st);
        }

        if (isCross(points[0], points[1], points[2], points[3])) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static int ccw(Coordinate a, Coordinate b, Coordinate c) {
        // (x1y2 + x2y3 + x3y1) - (x2y1 + x3y2 + x1y3)
        long res = (a.x*b.y + b.x*c.y + c.x*a.y) - (b.x*a.y + c.x*b.y + a.x*c.y);

        if(res == 0){
            return 0;
        }
        return res>0?1:-1;
    }

    private static boolean isCross(Coordinate a, Coordinate b, Coordinate c, Coordinate d) {
        int ab = ccw(a, b, c) * ccw(a, b, d);
        int cd = ccw(c, d, a) * ccw(c, d, b);

        if (ab == 0 && cd == 0) {
            // 두 선분이 일직선일 때 범위가 겹치는지 체크
            return isOverlap(a, b, c, d);
        }

        return ab <= 0 && cd <= 0;
    }

    private static boolean isOverlap(Coordinate a, Coordinate b, Coordinate c, Coordinate d) {
        if (Math.max(a.x, b.x) < Math.min(c.x, d.x)) return false;
        if (Math.max(c.x, d.x) < Math.min(a.x, b.x)) return false;
        if (Math.max(a.y, b.y) < Math.min(c.y, d.y)) return false;
        if (Math.max(c.y, d.y) < Math.min(a.y, b.y)) return false;
        return true;
    }
}
