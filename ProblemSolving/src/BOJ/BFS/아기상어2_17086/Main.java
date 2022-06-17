import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Node{
	int y,x,d;
	Node(int y, int x, int d){
		this.y = y;
		this.x = x;
		this.d = d;
	}
}
public class Main {
	public static int getDistance(int[][] m, Node n) {
		boolean[][] v = new boolean[m.length][m[0].length];
		int[][] dist = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,1},{1,-1}};
		Queue<Node> q = new LinkedList<>();
		q.add(n);
		v[n.y][n.x]=true;
		while(!q.isEmpty()) {
			Node tn=q.poll();
			for(int i=0; i<dist.length; i++) {
				int y = tn.y+dist[i][0];
				int x = tn.x+dist[i][1];
				if(y>=0&&y<m.length&&x>=0&&x<m[0].length&&!v[y][x]) {
					if(m[y][x]==1) {
						return tn.d+1;
					}else {
						q.add(new Node(y,x,tn.d+1));
						v[y][x]=true;
					}
				}
			}			
		}
		return 0;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Scanner sc = new Scanner(System.in);
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int[][] m = new int[N][M];
		for(int i=0; i<N; i++) {
			String[] temp = br.readLine().split(" ");
			for(int j=0; j<temp.length; j++) {
				m[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for(int i=0; i<N;i++) {
			for(int j=0; j<M;j++) {
				if(m[i][j]==0) {
					pq.add(getDistance(m,new Node(i,j,0)));
				}
			}
		}
		
		System.out.println(pq.peek());
		
		bw.flush();
		bw.close();
		br.close();
	}
}