import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import java.util.*;

class Solution {
    int N;
    ArrayList<int[]> builds = new ArrayList<>();
    boolean[][] frame1;
    boolean[][] frame2;
    
    public int[][] solution(int n, int[][] build_frame) {
        N=n;
        frame1 = new boolean[n+1][n+1];
        frame2 = new boolean[n+1][n+1];
        for(int[] frame : build_frame){
            int order = frame[3];
            if(order==1){
                addFrame(frame[0],frame[1],frame[2]);
            }else{
                removeFrame(frame[0],frame[1],frame[2]);
            }
        }
        Collections.sort(builds,new Comparator<int[]>() {
    		@Override
    		public int compare(int[] o1, int[] o2) {
    			if(o1[0]!=o2[0]) {
    				return Integer.compare(o1[0], o2[0]);
    			}
    			return Integer.compare(o1[1], o2[1]);
    		}
		});
        
        int[][] answer = new int[builds.size()][3];
        for(int i = 0;i<builds.size();i++){
            answer[i][0] = builds.get(i)[0];
            answer[i][1] = builds.get(i)[1];
            answer[i][2] = builds.get(i)[2];
        }
        return answer;
    }
    
    public void addFrame(int x,int y,int option){
        if(option==0){
            if(y==0){
                builds.add(new int[]{x,y,option});
                frame1[x][y] = true;
            }else{
                if(isBound(x,y-1)&&frame1[x][y-1]){
                    builds.add(new int[]{x,y,option});
                    frame1[x][y] = true;
                }else if(isBound(x-1,y)&&frame2[x-1][y]){
                    builds.add(new int[]{x,y,option});
                    frame1[x][y] = true;
                }else if(isBound(x-1,y)&&frame2[x][y]){
                    builds.add(new int[]{x,y,option});
                    frame1[x][y] = true;
                }
            }
        }else{
            if(isBound(x,y-1)&&frame1[x][y-1]){
                builds.add(new int[]{x,y,option});
                frame2[x][y] = true;
            }else if(isBound(x+1,y-1)&&frame1[x+1][y-1]){
                builds.add(new int[]{x,y,option});
                frame2[x][y] = true;
            }else if((isBound(x-1,y)&&frame2[x-1][y])&&(isBound(x+1,y)&&frame2[x+1][y])){
                builds.add(new int[]{x,y,option});
                frame2[x][y] = true;
            }
        }
    }
    
    public void removeFrame(int x,int y,int option){
        if(option==0){
            boolean flag = true;
            if(isBound(x,y+1)&&frame1[x][y+1]) flag = false;
            if(isBound(x,y+1)&&frame2[x][y+1]){
                if(!(isBound(x+1,y)&&frame1[x+1][y])){
                    if(!((isBound(x-1,y+1)&&frame2[x-1][y+1])&&(isBound(x+1,y+1)&&frame2[x+1][y+1]))) flag = false;
                }
            }
            if(!flag){
                removeBuild(x,y,option);
            }
        }else{
            boolean flag = true;
            boolean prev = isBound(x-1,y)&&frame1[x-1][y];
            boolean next = isBound(x+1,y)&&frame1[x+1][y];
            boolean prevL = isBound(x,y-1)&&frame1[x][y-1];
            boolean nextL = isBound(x+1,y-1)&&frame1[x+1][y-1];
            
            if(isBound(x,y+1)&&frame1[x][y+1]) flag = false;
            
            
            if(!flag){
                removeBuild(x,y,option);
            }
        }
    }
    
    public void removeBuild(int x,int y,int option){
        for(int i = 0;i<builds.size();i++){
            int[] temp  =builds.get(i);
            if(temp[0]==x&&temp[1]==y&&temp[2]==option){
                builds.remove(i);
                return;
            }
        }
    }
    
    public boolean isBound(int x,int y){
        return !(0>x||x>N||y<0||y>N);
    }
    
    public boolean existPrevFrame1(int x,int y) {
    	
    	return true;
    }
    
    public boolean existNextFrame1(int x,int y) {
    	
    	return true;
    }
    
    public boolean existPrevFrame2(int x,int y) {
    	
    	return true;
    }
    
public boolean existNextFrame2(int x,int y) {
    	
    	return true;
    }
}