import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	//y, x는 각각 노드의 좌표, c는 걸음수, r은 남은 벽 부수기 횟수
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
		
		//0,0지점은 일단 시작지점이므로 방문한 것으로 취급
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0,0,1,1));
		visited[0][0][1] = true;
		
		//좌표를 1,2... N이 아닌
		//0, 1, ... N-1로 변경하기 위함
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
					//그것이 벽이고 아직 벽 부수기 기회가 남아있으며 아직 방문하지 않은 위치라면
					if(!map[y][x]&&n.r>0&&!visited[y][x][n.r-1]) {
						//벽을 부수고 방문한 것으로 취급
						q.add(new Node(y,x,n.c+1,n.r-1));
						visited[y][x][n.r-1] = true;
					}
					//그것이 길이고 아직 방문하지 않은 위치라면
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