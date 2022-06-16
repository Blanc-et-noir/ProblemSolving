package BOJ.BFS.영역구하기_2583;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Node{
	int y,x,cnt;
	Node(int y, int x){
		this.y = y;
		this.x = x;
	}
}
public class Main {

	public static void main(String[] args) {
		int N, M,K,i=0,j=0,k,cnt = 1,num=0;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		

		
		
		int[][] arr =new int[N][M];
		int[][] dist = {{-1,0},{1,0},{0,-1},{0,1}};
		boolean[][] visited = new boolean[N][M];
		Queue<Node> q = new LinkedList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();


		
		for(i=0; i<K; i++) {
			int lx,ly,rx,ry;
			lx=sc.nextInt();
			ly=sc.nextInt();
			rx=sc.nextInt();
			ry=sc.nextInt();
			for(j=ly; j<ry; j++) {
				for(k=lx; k<rx; k++) {
					visited[j][k]=true;
				}
			}
		}

		while(true) {
			cnt=1;
			while(!q.isEmpty()) {
				Node n = q.poll();
				for(i=0; i <4; i++) {
					int Y = n.y+dist[i][0];
					int X = n.x+dist[i][1];
					if(Y>=0&&Y<N&&X>=0&&X<M&&visited[Y][X]==false) {
						q.add(new Node(Y,X));
						visited[Y][X] = true;
						cnt++;
					}
				}
			}
			for(i=0;i<N;i++) {
				for(j=0; j<M;j++) {
					if(visited[i][j]==false) {
						break;
					}
				}
				if(j<M) {
					break;
				}
			}
			pq.add(cnt);
			num++;
			if(i<N) {
				q.add(new Node(i,j));
				visited[i][j]=true;
			}else {
				pq.poll();
				int size = pq.size();
				System.out.println(num-1);
				for(i=0;i<size;i++) {
					System.out.print(pq.poll()+" ");
				}
				return;
			}
		}

	}
}