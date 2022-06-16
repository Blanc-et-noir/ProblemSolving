package BOJ.BFS.적록색약_10026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	char c;
	int y,x;
	Node(char c,int y, int x){
		this.c = c;
		this.y = y;
		this.x = x;
	}
}

public class Main {
	public static int[][] dist = {{-1,0},{1,0},{0,-1},{0,1}};
	public static char[][] map;
	public static boolean[][] visited;
	public static boolean flag;
	public static int N,cnt,i,j;
	public static int BFS() {
		Queue<Node> q = new LinkedList<>();
		q = new LinkedList<>();
		q.add(new Node(map[0][0],0,0));
		visited = new boolean[N][N];
		visited[0][0] = true;
		cnt=0;
		while(true) {
			flag = false;
			while(!q.isEmpty()) {
				Node n = q.poll();
				for(i=0; i<dist.length; i++) {
					int y = n.y+dist[i][0];
					int x = n.x+dist[i][1];
					if(y>=0&&y<N&&x>=0&&x<N&&!visited[y][x]&&n.c==map[y][x]) {
						q.add(new Node(n.c,y,x));
						visited[y][x]=true;
					}
				}
			}
			
			cnt++;
			
			for(i=0; i<N; i++) {
				for(j=0; j<N; j++) {
					if(!visited[i][j]) {
						visited[i][j]=true;
						q.add(new Node(map[i][j],i,j));
						flag = true;
						break;
					}
				}
				if(flag) {
					break;
				}
			}
			if(!flag) {
				break;
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		String[] str;
		char[] temp;
		
		for(i=0; i<N;i++) {
			temp = br.readLine().toCharArray();
			for(j=0; j<N; j++) {
				map[i][j] = temp[j];
			}
		}
		
		int r1 = BFS();
		
		for(i=0; i<N; i++) {
			for(j=0; j<N; j++) {
				if(map[i][j]=='G') {
					map[i][j]='R';
				}
			}
		}
		
		int r2 = BFS();

		System.out.println(r1+" "+r2);		
		bw.close();
		br.close();
	}
}