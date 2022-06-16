package BOJ.BFS.로봇청소기_4991;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	int y, x, k, c;
	Node(int y, int x, int k, int c){
		this.y=y;
		this.x=x;
		this.k=k;
    //이동한 
		this.c=c;
	}
}

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Queue<Node> q;
	public static HashMap<String,Integer> hm;
	public static char[][] m;
  //쓰레기를 10개의 비트로 표현, 이를 방문배열의 세번째 값으로 활용
	public static boolean[][][] v;
	public static int W,H,K=0;
	public static int BFS() {
		int[][] dist = {{-1,0},{1,0},{0,-1},{0,1}};
		while(!q.isEmpty()) {
			Node n = q.poll();
      //쓰레기를 모두 치웠다면 종료
			if(n.k==K) {
				return n.c;
			}
			for(int i=0; i<dist.length; i++) {
				int y = n.y+dist[i][0];
				int x = n.x+dist[i][1];
				if(y>=0&&y<H&&x>=0&&x<W&&!v[y][x][n.k]) {
					if(m[y][x]=='*') {
						int s = hm.get(y+"&"+x);
						int t = 1<<s;
						q.add(new Node(y,x,n.k|t,n.c+1));
						v[y][x][n.k|t]=true;
					}else if(m[y][x]=='x') {
						continue;
					}else {
						q.add(new Node(y,x,n.k,n.c+1));
						v[y][x][n.k]=true;
					}
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) throws IOException{
		while(true) {
			String[] str = br.readLine().split(" ");
			K=0;
			W = Integer.parseInt(str[0]);
			H = Integer.parseInt(str[1]);
			if(W==0&&H==0) {
				break;
			}
			m = new char[H][W];
			v = new boolean[H][W][1024];
      //쓰레기 10개의 정보를 저장할 해시맵, y,x 위치의 쓰레기는 10비트 중에서 특정 1비트만 차지함
			hm = new HashMap<>();
			q = new LinkedList<>();
			for(int i=0; i<H;i++) {
				str = br.readLine().split("");
				for(int j=0;j<W;j++) {
					char ch = str[j].charAt(0);
					if(ch=='*') {
						K = K|(1<<hm.size());
						hm.put(i+"&"+j, hm.size());
						
					}else if(ch=='o') {
						q.add(new Node(i,j,0,0));
						v[i][j][0]=true;
					}
					m[i][j]=ch;
				}
			}
			bw.write(BFS()+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}