import java.util.*;

class Solution {
	//두 실수중 더 작은 값을 반환하는 메소드
    public static double min(double a, double b){
        return a>b?b:a;
    }
    
    public long solution(int w, int h) {
        long answer = 0;
        
        //한 열씩 탐색을 실시함
        for(long i=0; i<w; i++){
            
        	//직선의 방정식 y = ax에 대하여
        	//x좌표인 i, i+1을 각각 대입하여 y좌표를 구하고
        	//해당 y좌표를 소수점을 버린 값중에 더 작은값이 곧 직선 아래에 위치한
        	//정상적인 사각형들의 수를 의미함
        	
        	//이때 기울기 h/w를 미리 계산하고 이를 사용했다가는 6번 테스트케이스를 통과하지 못하는데
        	//이는 double 자료형이 실수를 정확히 표현하지 못하는 한계점 때문임
        	//따라서 모든 값을 곱하고 w를 나누는 식으로 직선의 방정식에 x값을 대입하는 것처럼
        	//표현해야만 정답으로 인정받을 수 있음
            double l = Math.floor(h*i/w);
            double r = Math.floor(h*(i+1)/w);
            
            long m = (long) min(l,r);
            
            answer = answer + m;
        }
        
        //직선 아래에 존재하는 정상적인 사각형의 수 x 2가 바로 전체 완전한 사각형의 수임
        answer=answer*2;
        
        return answer;
    }
}