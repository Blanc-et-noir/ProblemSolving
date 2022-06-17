import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Node{
	int y,x;
	Node(int y, int x){
		this.y=y;
		this.x=x;
	}
}

public class Main {
	public static int[][] m;
	public static boolean v[][];
	public static int BFS(Node sn) {
		int cnt=1;
		int[][] dist = {{-1,0},{1,0},{0,-1},{0,1}};
		Queue<Node> q = new LinkedList<>();
		q.add(sn);
		v[sn.y][sn.x] = true;
		while(!q.isEmpty()) {
			Node n = q.poll();
			for(int i=0; i<dist.length; i++) {
				int y = n.y + dist[i][0];
				int x = n.x + dist[i][1];
				if(y>=0&&y<m.length&&x>=0&&x<m[0].length&&!v[y][x]&&m[y][x]==1) {
					v[y][x]=true;
					q.add(new Node(y,x));
					cnt++;
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine()),sum=0,cnt=0;
		m = new int[N][N];
		v = new boolean[m.length][m.length];
		for(int i=0; i<N; i++) {
			String[] str = br.readLine().split("");
			for(int j=0; j<str.length; j++) {
				m[i][j] = Integer.parseInt(str[j]);
			}
		}
		boolean flag;
		while(true) {
			flag = false;
			for(int i=0; i<m.length; i++) {
				for(int j=0; j<m[0].length; j++) {
					if(m[i][j]==1&&v[i][j]==false) {
						pq.add(BFS(new Node(i,j)));
						flag = true;
						cnt++;
					}
				}
				if(flag==true) {
					break;
				}
			}
			if(flag == false) {
				break;
			}
		}
		System.out.println(cnt);
		while(!pq.isEmpty()) {
			bw.write(pq.poll()+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}