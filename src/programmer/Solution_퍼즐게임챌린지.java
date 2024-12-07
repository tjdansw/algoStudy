package programmer;

public class Solution_퍼즐게임챌린지 {
    int levelMax = Integer.MIN_VALUE;
    int levelMin = Integer.MAX_VALUE;
    int answer;
    
    public int solution(int[] diffs, int[] times, long limit) {
        findInterval(diffs);
        while(levelMax-levelMin>=0){
            int mid = (levelMin+levelMax)/2;
            if(check(diffs,times,limit,mid)){
                levelMax = mid-1;
            }else{
                levelMin = mid+1;
            }
        }
        return answer;
    }
    
    public void findInterval(int[] diffs){
        for(int diff : diffs){
            levelMax = Math.max(levelMax,diff);
            levelMin = Math.min(levelMin,diff);
        }
        answer = levelMax;
    }
    
    public boolean check(int[] diffs, int[] times, long limit,int level){
        long total = 0;
        for(int i = 0 ;i<diffs.length;i++){
            int diff = diffs[i];
            if(diff<=level){
                total+=times[i];
            }else{
                total+=(((i==0)?0:times[i-1])+times[i])*(diff-level)+times[i];
            }
        }
        if(total>=0&&total<=limit){
            answer = Math.min(answer,level);
            return true;
        }
        return false;
    }
}