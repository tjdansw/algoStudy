package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_23254 {
    static StringTokenizer st1,st2;
    static BufferedReader br;

    static int n,m, total=0;
    static PriorityQueue<Subject> pq;
    static class Subject{
        int remainScore;
        int timeOfScore;

        public Subject(int remainScore, int timeOfScore) {
            this.remainScore = remainScore;
            this.timeOfScore = timeOfScore;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_23254.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st1 = new StringTokenizer(br.readLine());
        n = 24*Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        pq = new PriorityQueue<>((a,b)->Integer.compare(b.timeOfScore,a.timeOfScore));

        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int score = Integer.parseInt(st1.nextToken());
            total+=score;
            pq.add(new Subject(100-score,Integer.parseInt(st2.nextToken())));
        }
        while(!pq.isEmpty()&&n>0){
            Subject subject = pq.poll();
            int time = subject.remainScore/subject.timeOfScore;
            if(n>=time){
                total+=subject.timeOfScore*time;
                n-=time;
                subject.remainScore-=subject.timeOfScore*time;
                if(subject.remainScore>0){
                    subject.timeOfScore = subject.remainScore;
                    pq.add(subject);
                }
            }else{
                total+=subject.timeOfScore*n;
                n=0;
            }
        }
        System.out.println(total);
    }
}
