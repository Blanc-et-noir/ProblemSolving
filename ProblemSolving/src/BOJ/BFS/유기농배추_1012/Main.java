import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	int y,x;
	Node(int y,int x){
		this.y=y;
		this.x=x;
	}
}

public class Main {
	public static int[][] map;
	public static boolean[][] visited;
	public static int BFS() {
		int[][] dist = {{-1,0},{1,0},{0,-1},{0,1}};
		int cnt=0;
		Queue<Node> q = new LinkedList<>();
		boolean flag = false;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j] == 1) {
					q.add(new Node(i,j));
					visited[i][j]=true;
					flag = true;
					break;
				}
			}
			if(flag == true) {
				break;
			}
		}
		while(true) {
			flag = false;
			while(!q.isEmpty()) {
				Node n = q.poll();
				for(int i=0; i<dist.length; i++) {
					int y = n.y + dist[i][0];
					int x = n.x + dist[i][1];
					if(y>=0&&y<map.length&&x>=0&&x<map[0].length&&!visited[y][x]&&map[y][x]==1) {
						visited[y][x] = true;
						q.add(new Node(y,x));
					}
				}
			}
			cnt++;
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map[i].length; j++) {
					if(map[i][j] == 1&&!visited[i][j]) {
						q.add(new Node(i,j));
						visited[i][j]=true;
						flag = true;
						break;
					}
				}
				if(flag == true) {
					break;
				}
			}
			if(flag==false) {
				return cnt;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int i,j,N,M,K ,T= Integer.parseInt(br.readLine());
		for(i=0; i<T; i++) {
			String[] str = br.readLine().split(" ");
			M = Integer.parseInt(str[0]);
			N = Integer.parseInt(str[1]);
			K = Integer.parseInt(str[2]);
			map = new int[N][M];
			visited = new boolean[N][M];
			for(j=0; j<K; j++) {
				str = br.readLine().split(" ");
				map[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = 1;
			}
			bw.write(BFS()+"\n");
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}