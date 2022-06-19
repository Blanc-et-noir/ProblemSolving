import java.util.*;

//해당 노드의 y, x좌표 및 비용 c를 저장하는 노드 클래스
class Node{
    int y, x, c;
    Node(int y, int x, int c){
        this.y = y;
        this.x = x;
        this.c = c;
    }
}

class Solution {
    public int solution(int[][] maps) {
    	//기본적으로는 탈출이 불가능하다고 가정
        int answer = -1;
        
        //BFS탐색시 반복문으로 상하좌우 방향을 지정하기 위한 배열
        int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
        
        Queue<Node> q = new LinkedList<Node>();
        boolean[][] v = new boolean[maps.length][maps[0].length];
        
        //(y=0, x=0 ) 좌표에서 탐색을 시작, 시작하는 칸 부터 비용을 세므로 비용은 1로 초기화
        q.add(new Node(0,0,1));
        v[0][0] = true;
        
        //중간에 while 반복문을 탈출하지 못한다면 탈출이 불가능한 것임
        while(!q.isEmpty()){
        	//큐에서 노드를 하나 꺼냄
            Node n = q.poll();
            
            //해당 노드가 목적지에 도착한 정보를 가지고 있다면 반복문을 탈출함
            if(n.y==maps.length-1&&n.x==maps[0].length-1){
                answer = n.c;
                break;
            }
            
            //현재위치로부터 상하좌우 탐색을 실시함
            for(int i=0; i<d.length; i++){
                //각각 상하좌우의 위치를 계산함
            	int y = n.y + d[i][0];
                int x = n.x + d[i][1];
                
                //만약 해당 위치가 maps의 범위를 벗어나지 않고, 아직 방문하지 않은 빈 공간이라면
                if(y>=0&&y<maps.length&&x>=0&&x<maps[0].length&&!v[y][x]&&maps[y][x]==1){
                	//해당위치를 방문표시하고 해당 노드의 비용을 1추가시켜 큐에 추가함
                	//반드시 방문배열을 체크할때는 큐에 추가할때 해야함
                	//큐에서 꺼낼때 방문체크하는경우 동일한 노드가 중복해서 들어갈 수 있음
                    q.add(new Node(y,x,n.c+1));
                    v[y][x] = true;
                }
            }
        }
        
        return answer;
    }
}