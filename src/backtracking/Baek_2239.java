package backtracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baek_2239 {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int[][] map = new int[9][9];
    static List<int[]> empty = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_2239.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        for (int i = 0; i < 9; i++) {
            line = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = line.charAt(j) - '0';
                if (map[i][j] == 0) {
                    empty.add(new int[]{i, j});
                }
            }
        }
        solve(0);
        System.out.println(sb);
    }

    static boolean solve(int idx) {
        if (idx == empty.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            return true;
        }

        int[] position = empty.get(idx);
        int row = position[0];
        int col = position[1];

        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                map[row][col] = num;
                if (solve(idx + 1)) return true;
                map[row][col] = 0;
            }
        }
        return false;
    }

    static boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (map[row][i] == num || map[i][col] == num) return false;
        }

        int startRow = (row / 3) * 3, startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (map[i][j] == num) return false;
            }
        }
        return true;
    }

    static void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }
}
