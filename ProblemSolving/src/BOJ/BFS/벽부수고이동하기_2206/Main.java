import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	//y, x�� ���� ����� ��ǥ, c�� ������, r�� ���� �� �μ��� Ƚ��
	int y, x, c, r;
	Node(int y, int x, int c, int r){
		this.y = y;
		this.x = x;
		this.c = c;
		this.r = r;
	}
}

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static boolean[][] map;
	public static boolean[][][] visited;
	public static int N, M;
	
	public static void BFS() throws Exception{
		int[][] dist = {{-1,0},{1,0},{0,-1},{0,1}};
		
		//0,0������ �ϴ� ���������̹Ƿ� �湮�� ������ ���
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0,0,1,1));
		visited[0][0][1] = true;
		
		//��ǥ�� 1,2... N�� �ƴ�
		//0, 1, ... N-1�� �����ϱ� ����
		N = N-1;
		M = M-1;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.y==M&&n.x==N) {
				bw.write(n.c+"\n");
				bw.flush();
				return;
			}
			for(int i=0; i<dist.length; i++) {
				int y = n.y + dist[i][0];
				int x= n.x + dist[i][1];
				//
				if(y>=0&&y<=M&&x>=0&&x<=N) {
					//�װ��� ���̰� ���� �� �μ��� ��ȸ�� ���������� ���� �湮���� ���� ��ġ���
					if(!map[y][x]&&n.r>0&&!visited[y][x][n.r-1]) {
						//���� �μ��� �湮�� ������ ���
						q.add(new Node(y,x,n.c+1,n.r-1));
						visited[y][x][n.r-1] = true;
					}
					//�װ��� ���̰� ���� �湮���� ���� ��ġ���
					if(map[y][x]&&!visited[y][x][n.r]) {
						q.add(new Node(y,x,n.c+1,n.r));
						visited[y][x][n.r] = true;
					}
				}
			}
		}
		bw.write("-1\n");
		bw.flush();
	}
	
	public static void main(String[] args) throws Exception{
		String[] temp = br.readLine().split(" ");
		M = Integer.parseInt(temp[0]);
		N = Integer.parseInt(temp[1]);
		
		map = new boolean[M][N];
		visited = new boolean[M][N][2];
		
		for(int i=0;i<M;i++) {
			temp = br.readLine().split("");
			for(int j=0; j<N;j++) {
				if(temp[j].equals("0")) {
					map[i][j] = true;
				}
			}
		}
		BFS();
	}
}