package greedy;

import java.util.*;
import java.io.*;

// 1931
public class Baek_1931 {
    static int n;
    static ArrayList<MeetingInfo> meetings = new ArrayList<>();

    static class MeetingInfo{
        int start, end;

        public MeetingInfo(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new MeetingInfo(start, end));
        }

        Collections.sort(meetings, (a, b)->{
            if(a.end==b.end) return Integer.compare(a.start, b.start);
            return Integer.compare(a.end, b.end);
        });
        int cnt = 0;
        int time = 0;
        for(MeetingInfo m:meetings){
            if(m.start>=time){
                time = m.end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
