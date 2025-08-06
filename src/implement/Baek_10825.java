package implement;

import java.util.*;
import java.io.*;

// 10825
public class Baek_10825 {
    static class Student {
        String name;
        int[] score = new int[3];

        public Student(StringTokenizer st) {
            this.name = st.nextToken();
            score[0] = Integer.parseInt(st.nextToken());
            score[1] = Integer.parseInt(st.nextToken());
            score[2] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Student> students = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            students.add(new Student(new StringTokenizer(br.readLine())));
        }
        Collections.sort(students,(a,b)->{
            if(a.score[0] == b.score[0] && a.score[1] == b.score[1] && a.score[2] == b.score[2]) {
                return a.name.compareTo(b.name);
            }else if(a.score[0] == b.score[0] && a.score[1] == b.score[1]){
                return Integer.compare(b.score[2], a.score[2]);
            }else if(a.score[0] == b.score[0]){
                return Integer.compare(a.score[1], b.score[1]);
            }else{
                return Integer.compare(b.score[0], a.score[0]);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Student s : students) {
            sb.append(s.name).append("\n");
        }
        System.out.println(sb);
    }
}
