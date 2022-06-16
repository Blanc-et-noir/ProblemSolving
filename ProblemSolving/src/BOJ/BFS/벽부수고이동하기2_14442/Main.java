package BOJ.BFS.벽부수고이동하기2_14442;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	//y, x는 각각 노드의 좌표, c는 걸음수, r은 남은 벽 부수기 횟수
	int x, y, c, r;
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
	
	//M, N은 각각 y축, x축의 길이, K는 벽을 부술 수 있는 총 횟수
	public static int N, M, K;
	
	public static void BFS() throws Exception{
		int[][] dist = {{-1,0},{1,0},{0,-1},{0,1}};
		
		//처음에는 K개의 벽 부수기 횟수를 가짐, 따라서 visited[0][0][K]를 방문한 것으로 취급
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0,0,1,K));
		visited[0][0][K] = true;
		
		//1, 2, 3, ... N이 아니라
		//0, 1, 2, ... N-1로 배열을 접근하기 위함
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
				
				if(y>=0&&y<=M&&x>=0&&x<=N) {
					//그것이 벽이고 벽부수기 횟수가 남아있으며 아직 방문하지 않은 위치라면
					if(!map[y][x]&&n.r>0&&!visited[y][x][n.r-1]) {
						//해당 노드로 이동하고 벽부수기 횟수를 감소시킴
						q.add(new Node(y,x,n.c+1,n.r-1));
						visited[y][x][n.r-1] = true;
					}
					//그것이 길이고 아직 방문하지 않은 위치라면
					if(map[y][x]&&!visited[y][x][n.r]) {
						//해당 노드로 이동
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
		K = Integer.parseInt(temp[2]);
		
		map = new boolean[M][N];
		visited = new boolean[M][N][K+1];
		
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