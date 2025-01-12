package input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baek_10814 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static ArrayList<People> list = new ArrayList<>();

    static class People{
        int id;
        int age;
        String name;

        public People(int id,int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_10814.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new People(i, Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        Collections.sort(list,new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.age == o2.age?Integer.compare(o1.id, o2.id):Integer.compare(o1.age, o2.age);
            }
        });
        for(People p : list){
            sb.append(p.age).append(" ").append(p.name).append("\n");
        }
        System.out.println(sb);
    }
}
