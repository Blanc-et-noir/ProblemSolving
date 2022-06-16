package BOJ.BFS.미로탈출_14923;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


class Node{
	//y,x는 각각 좌표, c는 이동 횟수, r은 남은 벽뚫기 횟수를 의미
	int x, y, c, r;
	Node(int y, int x, int c, int r){
		this.x = x;
		this.y = y;
		this.c = c;
		this.r = r;
	}
}

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	//방문배열은 3차원, 1,2차 인덱스는 각각 y, x좌표를, 3차 인덱스는 남은 벽뚫기 횟수
	public static boolean[][][] visited;
	public static boolean[][] map;
	
	//Hx, Hy는 각각 시작 x, y좌표를
	//Ex, Ey는 각각 끝 x, y좌표를 의미함
	public static int N,M, Hx, Hy, Ex, Ey;
	
	public static int BFS() throws Exception{
		int[][] dist = {{-1,0},{1,0},{0,-1},{0,1}};
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(Hy,Hx,0,1));
		visited[Hy][Hx][1] = true;
		
		while(!q.isEmpty()) {
			
			Node n = q.poll();
			
			if(n.x==Ex&&n.y==Ey) {
				return n.c;
			}
			
			for(int i=0; i<dist.length; i++) {
				int x = n.x + dist[i][1], y = n.y + dist[i][0];
				
				//방문배열의 3차 인덱스는 현재 남은 벽뚫기 횟수임
				if(x>=0&&x<M&&y>=0&&y<N) {
					//만약 벽이고 아직 벽뚫기 횟수가 남아있으며 방문하지 않았다면 이동함
					if(!map[y][x]&&n.r>0&&!visited[y][x][n.r-1]) {
						q.add(new Node(y,x,n.c+1,n.r-1));
						visited[y][x][n.r-1] = true;
					}
					//만약 벽이 아닌 길이면서 아직 방문하지 않았다면 이동함
					if(map[y][x]&&!visited[y][x][n.r]){
						q.add(new Node(y,x,n.c+1,n.r));
						visited[y][x][n.r] = true;
					}
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		
		visited = new boolean[N][M][2];
		map = new boolean[N][M];
		
		temp = br.readLine().split(" ");
		Hx = Integer.parseInt(temp[1]) - 1;
		Hy = Integer.parseInt(temp[0]) - 1;
		
		temp = br.readLine().split(" ");
		Ex = Integer.parseInt(temp[1]) - 1;
		Ey = Integer.parseInt(temp[0]) - 1;
		
		for(int i=0;i<N;i++) {
			temp = br.readLine().split(" ");
			for(int j=0; j<M;j++) {
				if(temp[j].equals("0")) {
					map[i][j]=true;
				}
			}
		}
		
		
		bw.write(BFS()+"\n");
		bw.flush();
	}
}