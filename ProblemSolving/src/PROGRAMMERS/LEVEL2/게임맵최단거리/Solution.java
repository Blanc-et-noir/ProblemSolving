import java.util.*;

//�ش� ����� y, x��ǥ �� ��� c�� �����ϴ� ��� Ŭ����
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
    	//�⺻�����δ� Ż���� �Ұ����ϴٰ� ����
        int answer = -1;
        
        //BFSŽ���� �ݺ������� �����¿� ������ �����ϱ� ���� �迭
        int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
        
        Queue<Node> q = new LinkedList<Node>();
        boolean[][] v = new boolean[maps.length][maps[0].length];
        
        //(y=0, x=0 ) ��ǥ���� Ž���� ����, �����ϴ� ĭ ���� ����� ���Ƿ� ����� 1�� �ʱ�ȭ
        q.add(new Node(0,0,1));
        v[0][0] = true;
        
        //�߰��� while �ݺ����� Ż������ ���Ѵٸ� Ż���� �Ұ����� ����
        while(!q.isEmpty()){
        	//ť���� ��带 �ϳ� ����
            Node n = q.poll();
            
            //�ش� ��尡 �������� ������ ������ ������ �ִٸ� �ݺ����� Ż����
            if(n.y==maps.length-1&&n.x==maps[0].length-1){
                answer = n.c;
                break;
            }
            
            //������ġ�κ��� �����¿� Ž���� �ǽ���
            for(int i=0; i<d.length; i++){
                //���� �����¿��� ��ġ�� �����
            	int y = n.y + d[i][0];
                int x = n.x + d[i][1];
                
                //���� �ش� ��ġ�� maps�� ������ ����� �ʰ�, ���� �湮���� ���� �� �����̶��
                if(y>=0&&y<maps.length&&x>=0&&x<maps[0].length&&!v[y][x]&&maps[y][x]==1){
                	//�ش���ġ�� �湮ǥ���ϰ� �ش� ����� ����� 1�߰����� ť�� �߰���
                	//�ݵ�� �湮�迭�� üũ�Ҷ��� ť�� �߰��Ҷ� �ؾ���
                	//ť���� ������ �湮üũ�ϴ°�� ������ ��尡 �ߺ��ؼ� �� �� ����
                    q.add(new Node(y,x,n.c+1));
                    v[y][x] = true;
                }
            }
        }
        
        return answer;
    }
}