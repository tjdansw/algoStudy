package binary_search;

import java.util.*;
import java.io.*;

// 16434
public class Baek_16434 {
    static int n;
    static long atk;
    static Room[] rooms;

    static class Room{
        int type;
        long a, h;

        public Room(int type, long a, long h) {
            this.type = type;
            this.a = a;
            this.h = h;
        }

        public Room(int type, long a) {
            this.type = type;
            this.a = a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        atk = Integer.parseInt(st.nextToken());
        rooms = new Room[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long h = Long.parseLong(st.nextToken());
            rooms[i] = new Room(type, a, h);
        }

        long l = 1, r = 1_000_000L*1_000_000L*200000L;
        while (l<=r){
            long maxHp = (l+r)/2;
            long curHp = maxHp;
            long curAtk = atk;
            boolean notDie = true;

            for (int i = 1; i <= n&&notDie; i++) {
                int type = rooms[i].type;
                if(type==1){
                    long monsterAtk = rooms[i].a;
                    long monsterHp = rooms[i].h;
                    long atkCount = (long)Math.ceil(monsterHp*1.0/curAtk);
                    long hitCount = atkCount-1;
                    curHp -= hitCount*monsterAtk;
                    if(curHp<1){
                        notDie = false;
                    }
                }else{
                    long upAtk = rooms[i].a;
                    long upHp = rooms[i].h;
                    curHp = Math.min(curHp+upHp, maxHp);
                    curAtk += upAtk;
                }
            }

            if(notDie){
                r = maxHp-1;
            }else{
                l = maxHp+1;
            }
        }

        System.out.println(l);
    }
}
