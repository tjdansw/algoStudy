package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_1181 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static TreeSet<Word> set = new TreeSet<>(new Comparator<Word>() {
        @Override
        public int compare(Word o1, Word o2) {
            if (o1.len == o2.len) return o1.text.compareTo(o2.text);
            return Integer.compare(o1.len, o2.len);
        }
    });

    static class Word {
        String text;
        int len;

        public Word(String text) {
            this.text = text;
            this.len = text.length();
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Word word = (Word) o;
            return len == word.len && Objects.equals(text, word.text);
        }

        @Override
        public int hashCode() {
            return Objects.hash(text, len);
        }
    }


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_1181.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) set.add(new Word(br.readLine()));
        for (Word w : set) sb.append(w.text).append("\n");
        System.out.println(sb);
    }
}
