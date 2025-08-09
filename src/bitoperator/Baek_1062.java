package bitoperator;

import java.util.*;
import java.io.*;

// 1062
/**
 * 접근
 * 1) K < 5면 기본 'antic' 알파벳 못 가르치므로 0 출력
 * 2) 'a','n','t','i','c' 5개는 무조건 포함
 * 3) 각 단어를 비트마스크로 변환 후, baseMask에 없는 문자들만 남겨 관리
 * 4) 남은 후보 알파벳 중에서 (K-5)개를 조합으로 선택해, 선택한 알파벳 집합(selectedMask)으로 읽을 수 있는 단어 수를 세어 최대값 갱신
 * 최적화 포인트(기본 수준)
 *  - 전체 후보 집합 U(antic 제외 등장한 알파벳의 합집합)만 대상으로 조합 탐색
 *  - (K-5) >= |U| 이면 모두 배울 수 있으므로 바로 N
 */
public class Baek_1062 {
    static int max=0;
    static int R;
    static int[] wordsMask;
    static ArrayList<Integer> candidateAlphabet = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if(k<5){
            System.out.println(0);
            return;
        }
        if(k==26){
            System.out.println(n);
            return;
        }

        int defaultMask = 0;
        defaultMask |= (1<<('a'-'a'));
        defaultMask |= (1<<('n'-'a'));
        defaultMask |= (1<<('t'-'a'));
        defaultMask |= (1<<('i'-'a'));
        defaultMask |= (1<<('c'-'a'));

        wordsMask = new int[n];
        int unionMask = 0;
        for(int i = 0; i < n; i++){
            String word = br.readLine();
            wordsMask[i] = 0;
            for(int j = 0; j < word.length(); j++){
                int bit = 1<<(word.charAt(j)-'a');
                wordsMask[i] |= bit;
            }
            wordsMask[i] &= ~defaultMask;
            unionMask |= wordsMask[i];
        }

        for(int i = 0; i < 26; i++){
            int bit = 1<<i;
            if((defaultMask & bit) != 0) continue;
            if((unionMask & bit) != 0) {
                candidateAlphabet.add(i);
            }
        }

        R = k-5;
        if(candidateAlphabet.size()<=R){
            System.out.println(n);
            return;
        }
        dfs(0,0,0);
        System.out.println(max);
    }

    static void dfs(int idx, int useCnt, int currentMask){
        if(useCnt==R){
            int cnt = 0;
            for(int word:wordsMask){
                if((word&~currentMask) == 0){
                    cnt++;
                }
            }
            max = Math.max(max,cnt);
            return;
        }
        if(idx==candidateAlphabet.size()){
            return;
        }

        int bit = 1<<candidateAlphabet.get(idx);
        dfs(idx+1,useCnt+1,currentMask | bit);
        dfs(idx+1,useCnt,currentMask);
    }
}
