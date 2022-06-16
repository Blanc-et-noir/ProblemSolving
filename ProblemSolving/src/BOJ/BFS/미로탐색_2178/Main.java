package BOJ.BFS.¹Ì·ÎÅ½»ö_2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
	int y,x,cnt;
	Node(int y, int x, int cnt){
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}

public class Main {

	public static void main(String[] args) {
		int N, M;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		int[][] arr =new int[N][M];
		int[][] dist = {{-1,0},{1,0},{0,-1},{0,1}};
		boolean[][] visited = new boolean[N][M];
		Queue<Node> q =new LinkedList<>();
		for(int i=0; i<N;i++) {
			String str = sc.nextLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(str.substring(j,j+1));
			}
		}
		q.add(new Node(0,0,1));
		visited[0][0] = true;
		while(!q.isEmpty()) {
			Node n = q.poll();
			for(int i=0; i <4; i++) {
				int Y = n.y+dist[i][0];
				int X = n.x+dist[i][1];
				if(Y==N-1&&X==M-1) {
					System.out.println(n.cnt+1);
					return;
				}
				if(Y>=0&&Y<N&&X>=0&&X<M&&visited[Y][X]==false&&arr[Y][X]==1) {
					q.add(new Node(Y,X,n.cnt+1));
					visited[Y][X] = true;
				}
			}
		}
	}

}